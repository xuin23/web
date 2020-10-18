package com.cloud.auth.core.controller;

import com.cloud.auth.entity.AuthGroup;
import com.cloud.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户组 provider
 */
@RestController
@RequestMapping(value = "/authGroup")
public class AuthGroupController extends BaseController<AuthGroup> {

}
