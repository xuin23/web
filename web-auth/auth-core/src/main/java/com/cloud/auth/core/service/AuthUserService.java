package com.cloud.auth.core.service;

import com.cloud.auth.core.service.base.BaseService;
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
    public AuthUser findByUserName(String username) {
        return authUserMapper.findByUserName(username);
    }

    /**
     * 通过邮箱查询用户信息
     *
     * @param email 邮箱
     * @return AuthUser
     */
    public AuthUser findByEmail(String email) {
        return authUserMapper.findByEmail(email);
    }


    /**
     * 修改或添加用户信息
     *
     * @param authUser 用户信息
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void merge(AuthUser authUser) {
        if (null != authUser.getId()) {
            log.info("用户信息更新{}", authUser);
            modifyById(authUser, authUser.getId());
        } else {
            log.info("新建用户 {}", authUser);
            create(authUser);
        }
    }

}
