package com.cloud.auth.core.biz;


import com.cloud.auth.entity.AuthUser;

/**
 * 用户 业务
 */
public interface AuthUserBiz {

    /**
     * 修改或添加用户信息
     *
     * @param authUser
     */
    void merge(AuthUser authUser);
}
