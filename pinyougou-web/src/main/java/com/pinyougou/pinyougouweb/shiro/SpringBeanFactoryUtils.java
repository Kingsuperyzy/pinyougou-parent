package com.pinyougou.pinyougouweb.shiro;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


public class SpringBeanFactoryUtils implements ApplicationContextAware {
    private static ApplicationContext context = null;

    public static<T> T getBean(Class<T> type){
        return context.getBean(type);
    }
    public static<T> T getBean(String name,Class<T> type){
        return context.getBean(name,type);
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringBeanFactoryUtils.context == null){
            SpringBeanFactoryUtils.context = applicationContext;
        }
    }
}
