package com.cloud.message.biz;

/**
 * email 业务
 */
public interface EmailBiz {

    /**
     * 发送邮箱验证码
     *
     * @param email 邮箱
     */
    void sendSecurityCode(String email);
}
