package com.blog.blogsit.learn.spring;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.beanutils.PropertyUtils;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.ObjectUtils;

/**
 * @author hua.chen 2016年3月15日 下午11:16:05 <br>
 */
public class IocContainer {
    /** 内存存取 **/
    private Map<String, Object> component = Maps.newHashMap();

    public IocContainer() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(
                    "/Users/blogsit/qunarProjects/blogsitjavabase/src/main/source/component.properties"));

            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                String key = ObjectUtils.toString(entry.getKey());
                String value = ObjectUtils.toString(entry.getValue());
                if (key.split("\\.").length == 1) {
                    this.handler(key, value);
                }
            }
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                String key = ObjectUtils.toString(entry.getKey());
                String value = ObjectUtils.toString(entry.getValue());
                if (key.split("\\.").length == 2) {
                    this.handler(key, value);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("配置文件不存在");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("配置文件不存在");
            e.printStackTrace();
        }
    }

    /**
     * 核心类完成配置文件到对象的转化
     * 
     * @param key
     * @param value
     * @throws Exception
     */
    private void handler(String key, String value) throws Exception {
        String[] parts = key.split("\\.");
        if (parts.length == 1) {
            Object object = Class.forName(value).newInstance();
            this.component.put(key, object);
        } else if (parts.length == 2) {
            Object object = this.component.get(parts[0]);
            Object reference = this.component.get(value);
            // 通过setter注入
            PropertyUtils.setProperty(object, parts[1], reference);
        }
    }

    /**
     * 获取相对应的对象
     * 
     * @param key
     * @return
     */
    public Object getComponent(String key) {
        return this.component.get(key);
    }
}
