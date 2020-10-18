package com.cloud.auth.core.controller;

import com.cloud.auth.core.service.AuthUserService;
import com.cloud.auth.entity.AuthUser;
import com.cloud.common.base.BaseController;
import com.cloud.common.bean.ResultBean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户 provider
 */
@RestController
@RequestMapping(value = "/authUser")
public class AuthUserController extends BaseController<AuthUser> {

    /**
     * 用户 service
     */
    @Resource
    private AuthUserService authUserService;

    /**
     * 通过邮箱查询用户信息
     *
     * @param email 邮箱
     * @return ResultsBean<AuthUser>
     */
    @GetMapping(value = "/email/{email}")
    public ResultBean<AuthUser> findByEmail(@PathVariable String email) {
        List<AuthUser> authUserList = authUserService.findByEmail(email);
        if (authUserList.isEmpty()) {
            throw new RuntimeException("this email is empty");
        }
        if (authUserList.size() > 1) {
            throw new RuntimeException("this email number is over 2");
        }
        return ResultBean.SUCCESS(authUserList.get(0));
    }

}
