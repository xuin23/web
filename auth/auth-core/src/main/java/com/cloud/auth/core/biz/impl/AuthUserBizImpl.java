package com.cloud.auth.core.biz.impl;


import com.cloud.auth.core.biz.AuthUserBiz;
import com.cloud.auth.core.service.AuthUserService;
import com.cloud.auth.entity.AuthUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户 业务
 */
@Slf4j
@Component
public class AuthUserBizImpl implements AuthUserBiz {

    /**
     * 用户 service
     */
    @Resource
    private AuthUserService authUserService;

    /**
     * 修改或添加用户信息
     *
     * @param authUser
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void merge(AuthUser authUser) {
        if (null != authUser.getId()) {
            log.info("用户信息更新{}", authUser);
            authUserService.modifyById(authUser, authUser.getId());
        } else {
            log.info("新建用户 {}", authUser);
            authUserService.create(authUser);
        }
    }
}
