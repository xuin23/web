package com.cloud.message.mq.listener;

import com.cloud.common.constant.MqConstants;
import com.cloud.message.biz.IEmailBiz;
import lombok.extern.slf4j.Slf4j;
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
    private IEmailBiz emailBiz;


    /**
     * 处理邮箱验证码消息
     *
     * @param email 邮箱名称
     */
    @RabbitListener(queues = MqConstants.EMAIL_SECURITY_CODE)
    public void emailMessage(String email) {
        log.info("receive email name {}", email);
        try {
            emailBiz.sendSecurityCode(email);
            log.info("send email success,{}", email);
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
        }
    }
}
