package com.cloud.operator.mq;

import com.cloud.message.common.constant.MessageConstants;
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
        log.info("Email send key:{},msg:{}", MessageConstants.EMAIL_SECURITY_CODE, username);
        rabbitTemplate.convertAndSend(MessageConstants.EMAIL_SECURITY_CODE, username);
        log.info("Email send key:{},msg:{}, over", MessageConstants.EMAIL_SECURITY_CODE, username);
    }

}
