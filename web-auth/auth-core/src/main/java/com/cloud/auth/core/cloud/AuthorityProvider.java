package com.cloud.auth.core.cloud;

import com.cloud.auth.entity.Authority;
import com.cloud.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 权限 provider
 */
@RestController
@RequestMapping(value = "/cloud/authority")
public class AuthorityProvider extends BaseController<Authority> {

}
