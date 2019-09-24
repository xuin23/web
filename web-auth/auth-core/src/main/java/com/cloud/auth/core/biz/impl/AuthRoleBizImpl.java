package com.cloud.auth.core.biz.impl;


import com.cloud.auth.core.biz.AuthRoleBiz;
import com.cloud.auth.core.service.AuthRoleService;
import com.cloud.auth.entity.AuthRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 角色 业务
 */
@Slf4j
@Component
public class AuthRoleBizImpl implements AuthRoleBiz {

    /**
     * 角色 service
     */
    @Resource
    private AuthRoleService authRoleService;

    /**
     * 修改或添加消息信息
     *
     * @param authRole 角色信息
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void merge(AuthRole authRole) {
        if (null != authRole.getId()) {
            log.info("用户信息更新{}", authRole);
            authRoleService.modifyById(authRole, authRole.getId());
        } else {
            log.info("新建用户 {}", authRole);
            authRoleService.create(authRole);
        }
    }
}
