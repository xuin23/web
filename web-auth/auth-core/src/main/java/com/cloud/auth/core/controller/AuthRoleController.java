package com.cloud.auth.core.controller;

import com.cloud.auth.entity.AuthRole;
import com.cloud.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色 provider
 */
@RestController
@RequestMapping(value = "/authRole")
public class AuthRoleController extends BaseController<AuthRole> {

}
