package com.cloud.service.auth.controller;

import com.cloud.service.auth.base.BaseController;
import com.cloud.service.auth.entity.AuthUserRole;
import com.cloud.service.auth.service.AuthUserRoleService;
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
