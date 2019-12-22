package com.cloud.auth.core.service;

import com.cloud.common.base.BaseService;
import com.cloud.auth.entity.AuthUser;
import com.cloud.auth.mapper.AuthUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户 service
 */
@Slf4j
@Service
public class AuthUserService extends BaseService<AuthUser> {

    /**
     * 用户 mapper
     */
    @Resource
    private AuthUserMapper authUserMapper;

    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return AuthUser
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public AuthUser findByUserName(String username) {
        return authUserMapper.findByUserName(username);
    }

    /**
     * 通过邮箱查询用户信息
     *
     * @param email 邮箱
     * @return AuthUser
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public AuthUser findByEmail(String email) {
        return authUserMapper.findByEmail(email);
    }

}
