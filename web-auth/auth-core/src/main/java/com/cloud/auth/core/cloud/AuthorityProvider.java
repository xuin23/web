package com.cloud.auth.core.cloud;

import com.cloud.auth.entity.Authority;
import com.cloud.common.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 权限 provider
 */
@Slf4j
@RestController
@RequestMapping(value = "/cloud/authority")
public class AuthorityProvider extends BaseController<Authority> {

}
