package com.cloud.operator.mq;

import com.cloud.common.constant.MqConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Email mq
 */
@Slf4j
@Component
public class EmailProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送邮箱
     *
     * @param username 用户名（邮箱）
     */
    public void sendEmailMessage(String username) {
        log.info("Email send key:{},msg:{}",MqConstants.EMAIL_SECURITY_CODE,username);
        rabbitTemplate.convertAndSend(MqConstants.EMAIL_SECURITY_CODE, username);
        log.info("Email send key:{},msg:{}, over", MqConstants.EMAIL_SECURITY_CODE, username);
    }

}
