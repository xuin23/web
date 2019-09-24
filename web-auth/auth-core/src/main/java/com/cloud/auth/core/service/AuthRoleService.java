package com.cloud.auth.core.service;

import com.cloud.auth.core.service.base.BaseService;
import com.cloud.auth.entity.AuthRole;
import com.cloud.auth.mapper.AuthRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 角色 service
 */
@Slf4j
@Service
public class AuthRoleService extends BaseService<AuthRole> {

    /**
     * 角色 mapper
     */
    @Resource
    private AuthRoleMapper authRoleMapper;


    /**
     * 修改或添加消息信息
     *
     * @param authRole 角色信息
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void merge(AuthRole authRole) {
        if (null != authRole.getId()) {
            log.info("用户信息更新{}", authRole);
            modifyById(authRole, authRole.getId());
        } else {
            log.info("新建用户 {}", authRole);
            create(authRole);
        }
    }

}
