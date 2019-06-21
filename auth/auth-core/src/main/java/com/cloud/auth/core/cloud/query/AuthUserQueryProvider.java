package com.cloud.auth.core.cloud.query;

import com.cloud.auth.core.service.AuthUserService;
import com.cloud.auth.entity.AuthUser;
import com.cloud.common.bean.ResultsBean;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用户查询 provider
 */
@Slf4j
@RestController
@RequestMapping(value = "/cloud/authUserQuery")
public class AuthUserQueryProvider {

    /**
     * 用户 service
     */
    @Resource
    private AuthUserService authUserService;

    /**
     * 列表查询用户信息
     *
     * @param params
     * @return
     */
    @GetMapping(value = "/findByPageAll")
    public ResultsBean<PageInfo<Map<String, Object>>> findByPageAll(@RequestBody Map<String, Object> params) {
        PageInfo<Map<String, Object>> page = authUserService.findByPageAll(params);
        return ResultsBean.SUCCESS(page);
    }

    /**
     * 通过id查询用户信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/findById/{id}")
    public ResultsBean<AuthUser> findById(@PathVariable("id") Long id) {
        AuthUser authUser = authUserService.findById(id);
        return ResultsBean.SUCCESS(authUser);
    }

    /**
     * 通过用户名查询用户信息
     *
     * @param username
     * @return
     */
    @GetMapping(value = "/findByUserName")
    public ResultsBean<AuthUser> findByUserName(@RequestParam("username") String username) {
        AuthUser authUser = authUserService.findByUserName(username);
        return ResultsBean.SUCCESS(authUser);
    }

}