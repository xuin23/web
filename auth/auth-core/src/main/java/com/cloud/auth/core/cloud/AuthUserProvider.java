package com.cloud.auth.core.cloud;

import com.cloud.auth.core.service.AuthUserService;
import com.cloud.auth.entity.AuthUser;
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
public class AuthUserProvider {

    /**
     * 用户 service
     */
    @Resource
    private AuthUserService authUserService;

    @DeleteMapping(value = "/deleteById/{id}")
    public ResultsBean<String> deleteById(@PathVariable("id") Long id) {
        log.info("用户信息删除 ID={}", id);
        authUserService.deleteById(id);
        return ResultsBean.SUCCESS();
    }

    @PostMapping(value = "createOrUpdate")
    public ResultsBean<String> createOrUpdate(@RequestBody AuthUser authUser) {
        if (null != authUser.getId()) {
            log.info("用户信息更新{}", authUser);
            authUserService.modifyById(authUser, authUser.getId());
        } else {
            log.info("新建用户 {}", authUser);
            authUserService.create(authUser);
        }
        return ResultsBean.SUCCESS();
    }


}
