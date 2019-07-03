package com.cloud.auth.core.service;

import com.cloud.auth.core.service.base.BaseService;
import com.cloud.auth.entity.AuthRole;
import com.cloud.auth.mapper.AuthRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色 service
 */
@Service
public class AuthRoleService extends BaseService<AuthRole> {

    /**
     * 角色 mapper
     */
    @Resource
    private AuthRoleMapper authRoleMapper;

}
