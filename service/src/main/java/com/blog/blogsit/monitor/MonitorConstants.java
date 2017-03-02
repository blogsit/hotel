package com.blog.blogsit.monitor;

/**
 * 监控常量配置
 *
 * @author hua.chen
 * @date 2017年03月01 09:54
 */
public class MonitorConstants {
    // sql查询的结果集大于该值打印日志
    public static final int     DEFAULT_MASS_RESULT_LOG_SIZE               = 50;
    // sql查询的结果集大于该值记录监控
    public static final int     DEFAULT_MASS_RESULT_MONITOR_SIZE           = 3000;
    // 慢事务执行时间阈值
    public static final long    DEFAULT_SLOW_TRANSACTION_EXECUTE_THRESHOLD = 500;
    // 记录一个事务中sql的最大数量
    public static final int     DEFAULT_SQL_STAT_MAX_SIZE                  = 10;
    // 监控线程池采样间隔
    public static final long    THREAD_POOL_MONITOR_PERIOD_TIME_MILLIS     = 3000;
    // 事件处理器名字
    public static final String  EVENT_HANDLER                              = "EVENT_HANDLER_";
    // 事件总线的线程数量
    public static final int     DEFAULT_BASE_ASYNC_EVENT_BUS_THREAD_NUMBER = 1;
    // 事件总线的队列大小
    public static final int     DEFAULT_BASE_ASYNC_EVENT_BUS_QUEUE_SIZE = 1000;
    // 事件总线独立线程池
    public static final String  INDEPENDENT_BASE_ASYNC_EVENT_BUS_TYPE   = "INDEPENDENT";
    // 事件总线共享线程池
    public static final String  SHARED_BASE_ASYNC_EVENT_BUS_TYPE        = "SHARED";
    // 事务监控中是否记录sql的参数,默认打开
    public static final boolean DEFAULT_LOG_SQL_PARAM                   = true;
    // 开启qtrace记录事务执行
    public static final boolean DEFAULT_QTRACE_RECORD_TRANSACTION       = true;
    // app调用trace是否开启debug模式
    public static final boolean DEFAULT_APP_NAME_CONFIGURATION_DEBUG    = false;
}
