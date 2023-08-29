package com.cloud.frame.spring.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Spring Context
 *
 * @author xulijian
 */
@Slf4j
@Component
@Configuration
public class SpringContext implements ApplicationContextAware {

    public SpringContext() {
        log.info("SpringContext Init");
    }

    // Spring应用上下文环境
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (null == SpringContext.applicationContext) {
            SpringContext.applicationContext = applicationContext;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) applicationContext.getBean(name);
    }

}
