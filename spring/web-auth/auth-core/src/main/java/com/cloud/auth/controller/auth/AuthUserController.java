package com.cloud.auth.controller.auth;

import com.cloud.auth.base.BaseController;
import com.cloud.auth.service.auth.AuthUserService;
import com.cloud.auth.entity.AuthUser;
import com.cloud.common.bean.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * 用户 provider
 */
@Slf4j
@RestController
@RequestMapping(value = "/authUser")
public class AuthUserController extends BaseController<AuthUser, Long> {

    @Resource
    private AuthUserService authUserService;

    /**
     * 查询所有
     *
     * @return ResultBean<List < T>>
     */
    @GetMapping(value = "")
    public ResultBean<List<AuthUser>> findAll() {
        List<AuthUser> all = authUserService.findAll();
        for (AuthUser authUser : all) {
            authUser.setOptimistic(authUser.getOptimistic() + 1);
            AuthUser save = authUserService.save(authUser);
            log.info("{}", save);
        }
        return ResultBean.SUCCESS(all);
    }

}
