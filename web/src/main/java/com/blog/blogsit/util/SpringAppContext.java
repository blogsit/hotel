package com.blog.blogsit.util;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class SpringAppContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static <T> Map<String, T> getBeanOfType(Class<T> clazz) {
        return applicationContext.getBeansOfType(clazz);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName, Class<T> clazz) {
        return (T) applicationContext.getBean(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext act) throws BeansException {
        this.applicationContext = act;

    }

}
