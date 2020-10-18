package com.cloud.auth.core.controller;

import com.cloud.auth.entity.AuthUserGroup;
import com.cloud.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户用户组关联 provider
 */
@RestController
@RequestMapping(value = "/authUserGroup")
public class AuthUserGroupProvider extends BaseController<AuthUserGroup> {

}
