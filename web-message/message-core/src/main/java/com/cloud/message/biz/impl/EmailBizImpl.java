package com.cloud.message.biz.impl;

import com.cloud.common.constant.CacheKeyConstants;
import com.cloud.common.utils.SecurityCodeUtil;
import com.cloud.message.biz.EmailBiz;
import com.cloud.message.common.bean.EmailBean;
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
public class EmailBizImpl implements EmailBiz {

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
        EmailBean bean = new EmailBean();
        bean.setFrom(from);
        bean.setTo(email);
        bean.setSubject("邮箱验证码");
        bean.setText(generateSecurityCode());
        //发送邮箱
        sendEmail(bean);
        //验证码缓存
        cacheSecurityCode(bean);
    }


    /**
     * 验证码redis缓存
     *
     * @param bean 邮箱实体
     */
    private void cacheSecurityCode(EmailBean bean) {
        //key
        String key = CacheKeyConstants.EMAIL_SECURITY_PREFIX + bean.getTo();
        //设置验证码
        redisTemplate.opsForValue().set(key, bean.getText());
        //设置过期时间 5 分钟
        redisTemplate.expire(key, 60 * 5, TimeUnit.SECONDS);
    }

    /**
     * 生产验证码
     *
     * @return 验证码
     */
    private String generateSecurityCode() {
        return SecurityCodeUtil.generateSecurityCode(6);
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
            log.info("邮箱发送成功:{}", bean);
        } catch (MailException e) {
            log.error("邮件发送失败:{}", e.getMessage());
        }
    }
}
