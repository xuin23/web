package com.cloud.auth.core.cloud;

import com.cloud.auth.entity.AuthMenuAuthority;
import com.cloud.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 权限菜单关联 provider
 */
@RestController
@RequestMapping(value = "/cloud/authMenuAuthority")
public class AuthMenuAuthorityProvider extends BaseController<AuthMenuAuthority> {

}
