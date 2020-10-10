package com.cloud.message.service.impl;

import com.cloud.common.utils.SecurityCodeUtil;
import com.cloud.message.service.EmailService;
import com.cloud.message.common.bean.EmailBean;
import com.cloud.message.common.constant.MessageConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;

/**
 * 邮件 业务
 */
@Slf4j
@Component
public class EmailServiceImpl implements EmailService {

    /**
     * 邮箱发送人
     */
    @Value("${spring.mail.username:}")
    private String from;

    /**
     * 邮箱发送
     */
    @Resource
    private JavaMailSender javaMailSender;

    /**
     * redis
     */
    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * 发送邮箱验证码
     *
     * @param email 邮箱
     */
    @Override
    public void sendSecurityCode(String email) {
        //初始化邮箱消息
        EmailBean bean = initData(email);
        //发送邮箱
        sendEmail(bean);
        //验证码缓存
        cacheSecurityCode(bean);
    }

    /**
     * 初始化邮箱验证码信息
     *
     * @param email 邮箱地址
     * @return EmailBean
     */
    private EmailBean initData(String email) {
        EmailBean bean = new EmailBean();
        bean.setFrom(from);
        bean.setTo(email);
        bean.setSubject("邮箱验证码");
        bean.setText(SecurityCodeUtil.generateSecurityCode(6, SecurityCodeUtil.CODE_TYPE_CH));
        return bean;
    }


    /**
     * 验证码redis缓存
     *
     * @param bean 邮箱实体
     */
    private void cacheSecurityCode(EmailBean bean) {
        //key
        String key = MessageConstants.EMAIL_SECURITY_CODE_PREFIX + bean.getTo();
        //设置验证码
        redisTemplate.opsForValue().set(key, bean.getText());
        //设置过期时间 5 分钟
        redisTemplate.expire(key, 60 * 5, TimeUnit.SECONDS);
    }

    /**
     * 发送邮箱
     *
     * @param bean 邮箱实体
     */
    private void sendEmail(EmailBean bean) {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom(bean.getFrom());
        //邮件接收人
        message.setTo(bean.getTo());
        //邮件主题
        message.setSubject(bean.getSubject());
        //邮件内容
        message.setText(bean.getText());
        try {
            javaMailSender.send(message);
            log.info("email send success:{}", bean);
        } catch (MailException e) {
            log.error("email send fault:{}", e.getMessage());
            throw new RuntimeException("email send fault", e);
        }
    }
}
