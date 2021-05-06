package com.cloud.operator.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign 配置
 */
@Configuration
public class FeignConfig {

    @Bean
    public Retryer retryer() {
        //return Retryer.NEVER_RETRY;
        return new Retryer.Default();
    }

}
