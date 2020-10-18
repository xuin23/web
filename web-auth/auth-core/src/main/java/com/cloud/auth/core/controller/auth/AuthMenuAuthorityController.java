package com.cloud.auth.core.controller.auth;

import com.cloud.auth.entity.AuthMenuAuthority;
import com.cloud.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 权限菜单关联 provider
 */
@RestController
@RequestMapping(value = "/authMenuAuthority")
public class AuthMenuAuthorityController extends BaseController<AuthMenuAuthority> {

}
