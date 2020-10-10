package com.cloud.message.service;

/**
 * email 业务
 */
public interface EmailService {

    /**
     * 发送邮箱验证码
     *
     * @param email 邮箱
     */
    void sendSecurityCode(String email);
}
