package com.cloud.auth.core.controller.auth;

import com.cloud.auth.entity.AuthRoleGroup;
import com.cloud.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 角色用户组关联 provider
 */
@RestController
@RequestMapping(value = "/authRoleGroup")
public class AuthRoleGroupProvider extends BaseController<AuthRoleGroup> {

}
