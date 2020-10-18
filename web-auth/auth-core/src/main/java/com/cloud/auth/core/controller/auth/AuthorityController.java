package com.cloud.auth.core.controller.auth;

import com.cloud.auth.entity.Authority;
import com.cloud.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 权限 provider
 */
@RestController
@RequestMapping(value = "/authority")
public class AuthorityController extends BaseController<Authority> {

}
