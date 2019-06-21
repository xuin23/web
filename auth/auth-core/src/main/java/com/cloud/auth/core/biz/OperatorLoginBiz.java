package com.cloud.auth.core.biz;

import com.cloud.common.bean.Authorization;

/**
 * 操作员登录 业务
 */
public interface OperatorLoginBiz {

    /**
     * 登录
     *
     * @param username     用户名
     * @param password     密码
     * @param isSecurity   是否使用验证码
     * @param securityCode 验证码
     * @return
     */
    Authorization login(String username, String password,Boolean isSecurity, String securityCode);
}
