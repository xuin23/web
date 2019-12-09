package com.cloud.message.mq.listener;

import com.cloud.common.constant.MqConstants;
import com.cloud.message.biz.EmailBiz;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * email 监听
 */
@Slf4j
@Component
public class EmailListener {

    /**
     * email 业务
     */
    @Resource
    private EmailBiz emailBiz;


    /**
     * 处理邮箱验证码消息
     */
    @RabbitListener(queues = MqConstants.EMAIL_SECURITY_CODE)
    public void emailMessage(Message message, Channel channel) {
        String email = new String(message.getBody());
        log.info("receive email name {}", email);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
            emailBiz.sendSecurityCode(email);
            log.info("send email success,{}", email);
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
        }
    }
}
