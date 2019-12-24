package com.cloud.auth.core.cloud;

import com.cloud.auth.entity.AuthUserGroup;
import com.cloud.common.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户用户组关联 provider
 */
@Slf4j
@RestController
@RequestMapping(value = "/cloud/authUserGroup")
public class AuthUserGroupProvider extends BaseController<AuthUserGroup> {

}
