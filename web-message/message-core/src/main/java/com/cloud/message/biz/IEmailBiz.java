package com.cloud.message.biz;

/**
 * email 业务
 */
public interface IEmailBiz {

    /**
     * 发送邮箱验证码
     *
     * @param email 邮箱
     */
    public void sendSecurityCode(String email);
}
