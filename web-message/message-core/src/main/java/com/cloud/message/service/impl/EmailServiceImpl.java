package com.cloud.message.service.impl;

import com.cloud.common.utils.SecurityCodeUtil;
import com.cloud.message.service.EmailService;
import com.cloud.message.common.constant.MessageConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;

/**
 * 邮件Service 实现
 * 
 * @author xulijian
 */
@Slf4j
@Service
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
     * redisTemplate
     */
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 发送邮箱验证码
     *
     * @param email 邮箱地址
     * @author xulijian
     */
    @Override
    public void sendSecurityCode(String email) {
        // 初始化邮箱消息
        SimpleMailMessage message = initData(email);
        // 发送邮箱
        sendEmail(message);
        // 验证码缓存
        cacheSecurityCode(message);
    }

    /**
     * 初始化邮箱验证码信息
     *
     * @param email 邮箱地址
     * @return EmailBean
     * @author xulijian
     */
    private SimpleMailMessage initData(String email) {
        return new SimpleMailMessage() {
            {
                setFrom(from);
                setTo(email);
                setSubject("邮箱验证码");
                setText(SecurityCodeUtil.generateSecurityCode(6, SecurityCodeUtil.CODE_TYPE_CH));
            }
        };
    }

    /**
     * 验证码redis缓存
     *
     * @param message 邮箱实体
     * @author xulijian
     */
    private void cacheSecurityCode(SimpleMailMessage message) {
        // key
        String key = MessageConstants.EMAIL_SECURITY_CODE_PREFIX + message.getTo();
        // 设置验证码
        redisTemplate.opsForValue().set(key, message.getText());
        // 设置过期时间 5 分钟
        redisTemplate.expire(key, 60 * 5, TimeUnit.SECONDS);
    }

    /**
     * 发送邮箱
     *
     * @param message 邮箱实体
     * @author xulijian
     */
    private void sendEmail(SimpleMailMessage message) {
        try {
            javaMailSender.send(message);
            log.info("Email send success:{}", message);
        } catch (MailException e) {
            log.error("Email send fault:{}", e.getMessage());
            throw new RuntimeException("Email send fault:" + e.getMessage(), e);
        }
    }
}
