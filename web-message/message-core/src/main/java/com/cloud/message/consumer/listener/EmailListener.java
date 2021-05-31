package com.cloud.message.consumer.listener;

import com.cloud.message.service.EmailService;
import com.cloud.message.common.constant.MessageConstants;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 邮箱数据监听
 * 
 * @author xulijian
 */
@Slf4j
@Component
public class EmailListener {

    /**
     * Email 服务
     */
    @Resource
    private EmailService emailService;

    /**
     * 处理邮箱验证码消息 EMAIL_SECURITY_CODE
     * 
     * @author xulijian
     */
    @RabbitListener(queues = MessageConstants.EMAIL_SECURITY_CODE)
    public void emailSecurityCodeListener(Message message, Channel channel) {
        String email = new String(message.getBody());
        log.info("receive email name {}", email);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
            emailService.sendSecurityCode(email);
            log.info("send email success,{}", email);
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
        }
    }
}
