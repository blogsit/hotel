package com.blog.blogsit.utils;

import com.alibaba.fastjson.TypeReference;

/**
 * JSON转换提供者
 *
 * @author hua.chen
 * @create 2016年11月15日11:43
 **/
public interface JsonProvider {

    /**
     * 将对象转换为JSON字符串
     * 
     * @param obj
     * @return
     */
    String toJSONString(Object obj);

    /**
     * 将JSON字符串转换为对象
     * 
     * @param json
     * @param clazz
     * @return
     */
    <T> T fromJSONString(String json, Class<T> clazz);

    /**
     * 将JSON字符串转换为对象
     * 
     * @param json
     * @param typeRef
     * @return
     */
    <T> T fromJSONString(String json, TypeReference<T> typeRef);

}
