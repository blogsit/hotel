package com.blog.blogsit.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 枚举类型处理
 *
 * @author hua.chen
 * @date 2017年03月05 21:43
 */
public abstract class CodeEnumHandler<T extends Enum> implements TypeHandler<T> {
    private Class<Enum> entityClass;
    private Method codeMethod;
    private Map<Integer, Enum> codeEnumMap;

    public CodeEnumHandler() {
        entityClass = (Class<Enum>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            codeMethod = entityClass.getDeclaredMethod("code");
        } catch (NoSuchMethodException e) {

        } catch (SecurityException e) {
            throw new IllegalArgumentException(e);
        }
        if(codeMethod ==null){
            try{
                codeMethod = entityClass.getDeclaredMethod("getCode");
            }catch(NoSuchMethodException e){

            }
        }

        if (codeMethod == null) {
            try {
                codeMethod = entityClass.getDeclaredMethod("getIntValue");
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException(entityClass
                        + "#code():int method or getCode() or getIntValue():int is required! ", e);
            }
        }
        try {
            Method valuesMethod = entityClass.getDeclaredMethod("values");
            Enum[] enums = (Enum[]) valuesMethod.invoke(null);
            codeEnumMap = new HashMap<Integer, Enum>();
            for (Enum e : enums) {
                codeEnumMap.put((Integer) invokeCode(e), e);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, T t, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,invokeCode(t));
    }

    @Override
    public T getResult(ResultSet resultSet, String s) throws SQLException {
        return invokeCodeOf(resultSet.getInt(s));
    }

    @Override
    public T getResult(ResultSet resultSet, int i) throws SQLException {
        return invokeCodeOf(resultSet.getInt(i));
    }

    @Override
    public T getResult(CallableStatement callableStatement, int i) throws SQLException {
        return invokeCodeOf(callableStatement.getInt(i));
    }
    private T invokeCodeOf(int i) {
        Enum e = codeEnumMap.get(i);
        if (e == null) {
            throw new IllegalArgumentException("cannot mapping code " + i + " to enum " + entityClass
                    + ", have you defined code " + i + " in enum " + entityClass + "?");
        }
        return (T) e;
    }
    private int invokeCode(Object o) {
        try {
            return (Integer) codeMethod.invoke(o);
        } catch (Exception e) {
            throw new RuntimeException("invoke code method error!", e);
        }
    }
}
