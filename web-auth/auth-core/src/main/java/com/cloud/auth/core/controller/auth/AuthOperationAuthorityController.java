package com.cloud.auth.core.controller.auth;

import com.cloud.auth.entity.AuthOperationAuthority;
import com.cloud.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 权限操作关联 provider
 */
@RestController
@RequestMapping(value = "/authOperationAuthority")
public class AuthOperationAuthorityController extends BaseController<AuthOperationAuthority> {

}
