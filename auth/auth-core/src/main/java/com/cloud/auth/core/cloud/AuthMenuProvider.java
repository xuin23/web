package com.cloud.auth.core.cloud;

import com.cloud.auth.entity.AuthMenu;
import com.cloud.common.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 菜单 provider
 */
@Slf4j
@RestController
@RequestMapping(value = "/cloud/authMenu")
public class AuthMenuProvider extends BaseController<AuthMenu> {

}
