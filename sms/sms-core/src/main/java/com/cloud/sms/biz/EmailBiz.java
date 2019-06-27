package com.cloud.sms.biz;

/**
 * email 业务
 */
public interface EmailBiz {

    /**
     * 发送邮箱验证码
     *
     * @param email 邮箱
     */
    public void sendSecurityCode(String email);
}
