package com.cloud.auth.core.cloud;

import com.cloud.auth.entity.AuthOperationAuthority;
import com.cloud.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 权限操作关联 provider
 */
@RestController
@RequestMapping(value = "/cloud/authOperationAuthority")
public class AuthOperationAuthorityProvider extends BaseController<AuthOperationAuthority> {

}
