package com.cloud.auth.core.cloud;

import com.cloud.auth.core.service.AuthUserService;
import com.cloud.auth.entity.AuthUser;
import com.cloud.common.base.BaseController;
import com.cloud.common.bean.ResultsBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户 provider
 */
@Slf4j
@RestController
@RequestMapping(value = "/cloud/authUser")
public class AuthUserProvider extends BaseController<AuthUser> {

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
    public ResultsBean<AuthUser> findByEmail(@PathVariable String email) {
        AuthUser authUser = authUserService.findByEmail(email);
        return ResultsBean.SUCCESS(authUser);
    }

}
