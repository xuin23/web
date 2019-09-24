package com.cloud.auth.core.cloud;

import com.cloud.auth.core.biz.AuthUserBiz;
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

    /**
     * 用户 业务
     */
    @Resource
    private AuthUserBiz authUserBiz;

    /**
     * 通过id删除用户信息
     *
     * @param id id
     * @return ResultsBean<String>
     */
    @DeleteMapping(value = "/deleteById/{id}")
    public ResultsBean<String> deleteById(@PathVariable("id") Long id) {
        log.info("用户信息删除 ID={}", id);
        authUserService.deleteById(id);
        return ResultsBean.SUCCESS();
    }

    /**
     * 修改或添加用户信息
     *
     * @param authUser 用户信息
     * @return ResultsBean<String>
     */
    @PostMapping(value = "/merge")
    public ResultsBean<String> merge(@RequestBody AuthUser authUser) {
        authUserBiz.merge(authUser);
        return ResultsBean.SUCCESS();
    }


}
