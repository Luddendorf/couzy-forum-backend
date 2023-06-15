package com.breeze.summer.utils.log;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.lang.reflect.Field;

public class LoggerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for (String name : names) {
            Object bean = beanFactory.getBean(name);
            if (bean.getClass().isAnnotationPresent(Loggable.class)) {
                try {
                    Field field = bean.getClass().getDeclaredField("logger");
                    field.setAccessible(true);
                    field.set(bean, LoggerFactory.getLogger(bean.getClass()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}