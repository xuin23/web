package com.cloud.auth.core.cloud;

import com.cloud.auth.entity.AuthRoleGroup;
import com.cloud.common.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 角色用户组关联 provider
 */
@Slf4j
@RestController
@RequestMapping(value = "/cloud/authRoleGroup")
public class AuthRoleGroupProvider extends BaseController<AuthRoleGroup> {

}
