package com.cloud.message.config;

import com.cloud.common.constant.MqConstants;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitMq配置
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public DirectExchange basicExchange(){
        return new DirectExchange(MqConstants.EMAIL_SECURITY_CODE, true,false);
    }

    @Bean
    public Queue queue(){
        return new Queue(MqConstants.EMAIL_SECURITY_CODE, true);
    }
}
