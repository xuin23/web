package com.cloud.auth.controller.auth;

import com.cloud.auth.base.BaseController;
import com.cloud.auth.entity.AuthUserRole;
import com.cloud.auth.service.auth.AuthUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户角色关联 Controller
 * 
 * @author xulijian
 */
@Slf4j
@RestController
@RequestMapping(value = "/authUserRole")
public class AuthUserRoleController extends BaseController<AuthUserRole, Long> {

    /**
     * 用户角色关联 Service
     */
    @Resource
    private AuthUserRoleService authUserRoleService;

}
