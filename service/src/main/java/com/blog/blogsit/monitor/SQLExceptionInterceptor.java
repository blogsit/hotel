package com.blog.blogsit.monitor;

import com.blog.blogsit.utils.JSONUtil;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.net.InetAddress;
import java.util.Collection;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SQL异常监控
 *
 * @author hua.chen
 * @date 2017年03月01 09:48
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class SQLExceptionInterceptor implements Interceptor {
    private static Logger logger = LoggerFactory.getLogger(SQLExceptionInterceptor.class);
    private static Logger sqlMassCountLogger = LoggerFactory.getLogger("sqlMissCountLogger");

    private static final String MONITOR_SQL_EXCEPTION = "sql_exception";

    private static final String MONITOR_SQL_SLOW = "sql_slow";

    private static final String MONITOR_SQL_EXECUTE = "sql_execute";

    private static final String MONITOR_SQL_MASS_RESULT_SET = "sql_mass_result_set";
    private static InetAddress addr;
    private static String hostname;
    private static final Pattern NUM_PATTERN = Pattern.compile("\\d+");
    private static final int LOG_SIZE = MonitorConstants.DEFAULT_MASS_RESULT_LOG_SIZE;// 测试用1看效果，线上用30
    private static final int MONITOR_SIZE = MonitorConstants.DEFAULT_MASS_RESULT_MONITOR_SIZE;// 测试用1看效果，线上用3000

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long start, end;
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];

        Object parameter = null;
        if (invocation.getArgs().length > 1) {
            parameter = invocation.getArgs()[1];
        }

        try {
            start = System.currentTimeMillis();
            Object object = invocation.proceed();
            end = System.currentTimeMillis();
            if (end - start > 200) {
                String sql = mappedStatement.getBoundSql(parameter).getSql();
                logger.info("slow sql {} millis. sql: {}. parameter: {}", end - start, sql, JSONUtil.toJSONString(parameter));
            }

            // select返回结果大于LOG_SIZE条，就记录日志；大于MONITOR_SIZE，就写监控
            if (object instanceof Collection && ((Collection) object).size() > LOG_SIZE) {
                sqlMassCountLogger.info("mapper:{}, method: {}, resultSetSize: {}.", mappedStatement.getResource(),
                        mappedStatement.getId(), ((Collection) object).size());
                if (((Collection) object).size() > MONITOR_SIZE) {
                    sqlMassCountLogger.info("hostname {}.", ((Collection) object).size());
                }
            }

            return object;
        } catch (Exception e) {
            String sql = mappedStatement.getBoundSql(parameter).getSql();
            logger.error("SQL Error: {}, SQL Parameter: {}, Exception: {}", sql, JSONUtil.toJSONString(parameter), e.getMessage());
            throw e;
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
