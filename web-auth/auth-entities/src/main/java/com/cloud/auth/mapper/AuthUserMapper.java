package com.cloud.auth.mapper;

import com.cloud.auth.entity.AuthUser;
import com.cloud.common.base.BaseMapper;

/**
 * 用户 mapper
 */
public interface AuthUserMapper extends BaseMapper<AuthUser> {

    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return AuthUser
     */
    AuthUser findByUserName(String username);

    /**
     * 通过邮箱查询用户信息
     *
     * @param email 邮箱
     * @return AuthUser
     */
    AuthUser findByEmail(String email);
}