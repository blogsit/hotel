package com.blog.blogsit.model;

import java.util.*;

/**
 * 查询模型
 *
 * @author hua.chen
 * @date 2017年03月02 10:56
 */

@SuppressWarnings("unchecked")
public class BasicQuery extends HashMap<String, Object> {
    private static final long serialVersionUID = -3953297862552221965L;

    @SuppressWarnings("rawtypes")
    protected Class<? extends Enum> paramType;

    public BasicQuery() {
    }

    public BasicQuery(Class<? extends Enum<?>> paramType) {
        this.paramType = paramType;
    }

    public Object put(String key, Object value) {

        // 忽略无效参数
        if (key == null || value == null) {
            return null;
        }

        // 检查参数有效性
        if (paramType != null) {
            Enum.valueOf(paramType, (String) key);
        }

        return super.put(key, value);
    }

    protected Object putNoCheck(String key, Object value) {
        return super.put(key, value);
    }

    public Map<String, Object> getParamMap() {
        return Collections.unmodifiableMap(this);
    }

    public boolean hasParam(String name) {
        return containsKey(name);
    }

    public Object getParam(String name) {
        return get(name);
    }

    protected <T, P> T fillSet(String param, Set<P> value) {
        put(param, value);
        return (T) this;
    }

    protected <T, P> T fillSingleAsSet(String param, P singleValue) {
        Set<P> set = new HashSet<P>();
        set.add(singleValue);
        return (T) fillSet(param, set);
    }

    protected <T, P> T fillSingle(String param, P singleValue) {
        put(param, singleValue);
        return (T) this;
    }
}

