package com.cloud.service.auth.controller;

import com.cloud.service.auth.base.BaseController;
import com.cloud.service.auth.entity.Role;
import com.cloud.service.auth.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

/**
 * 用户角色关联 Controller
 * 
 * @author xulijian
 */
@Slf4j
@RestController
@RequestMapping(value = "/role")
public class RoleController extends BaseController<Role, Long> {

    /**
     * 用户角色关联 Service
     */
    @Resource
    private RoleService roleService;

}
