package com.cloud.auth.core.controller;

import com.cloud.auth.entity.AuthRoleAuthority;
import com.cloud.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 权限角色关联 provider
 */
@RestController
@RequestMapping(value = "/authRoleAuthority")
public class AuthRoleAuthorityController extends BaseController<AuthRoleAuthority> {

}
