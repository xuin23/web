package com.cloud.auth.core.cloud;

import com.cloud.auth.entity.AuthUserRole;
import com.cloud.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户角色关联 provider
 */
@RestController
@RequestMapping(value = "/cloud/authUserRole")
public class AuthUserRoleProvider extends BaseController<AuthUserRole> {

}
