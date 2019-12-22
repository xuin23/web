package com.cloud.auth.core.cloud;

import com.cloud.auth.core.service.AuthRoleService;
import com.cloud.auth.entity.AuthRole;
import com.cloud.common.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 角色 provider
 */
@Slf4j
@RestController
@RequestMapping(value = "/cloud/authRole")
public class AuthRoleProvider extends BaseController<AuthRole> {

    /**
     * 用户 service
     */
    @Resource
    private AuthRoleService authRoleService;

}
