package com.cloud.auth.controller.auth;

import com.cloud.auth.base.BaseController;
import com.cloud.auth.service.auth.AuthUserService;
import com.cloud.auth.entity.AuthUser;
import com.cloud.common.bean.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * 用户 Controller
 * 
 * @author xulijian
 */
@Slf4j
@RestController
@RequestMapping(value = "/authUser")
public class AuthUserController extends BaseController<AuthUser, Long> {

    @Resource
    private AuthUserService authUserService;

    @GetMapping(value = "/{id}")
    public ResultBean<AuthUser> findById(@PathVariable("id") Long id) {
        AuthUser authUser = authUserService.findById(id);
        log.info("{}", authUser);
        authUser.setRealname(String.valueOf((int) (Math.random() * 1000)));
        authUserService.save(authUser);
        return ResultBean.SUCCESS(authUserService.findById(id));
    }
}
