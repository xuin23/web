package com.cloud.auth.core.cloud;

import com.cloud.auth.entity.AuthGroup;
import com.cloud.common.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户组 provider
 */
@Slf4j
@RestController
@RequestMapping(value = "/cloud/authGroup")
public class AuthGroupProvider extends BaseController<AuthGroup> {

}
