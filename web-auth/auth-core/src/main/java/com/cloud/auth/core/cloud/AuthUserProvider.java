package com.cloud.auth.core.cloud;

import com.cloud.auth.core.service.AuthUserService;
import com.cloud.auth.entity.AuthUser;
import com.cloud.common.bean.ResultsBean;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

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
     * 通过id删除用户信息
     *
     * @param id id
     * @return ResultsBean<String>
     */
    @DeleteMapping(value = "/{id}")
    public ResultsBean<String> deleteById(@PathVariable("id") Long id) {
        log.info("用户信息删除 ID={}", id);
        authUserService.deleteById(id);
        return ResultsBean.SUCCESS();
    }

    /**
     * 修改用户信息
     *
     * @param authUser 用户信息
     * @return ResultsBean<String>
     */
    @PutMapping(value = "")
    public ResultsBean<String> update(@RequestBody AuthUser authUser) {
        if (null != authUser.getId()) {
            log.info("用户信息更新{}", authUser);
            authUserService.modifyById(authUser, authUser.getId());
        }
        return ResultsBean.SUCCESS();
    }

    /**
     * 添加用户信息
     *
     * @param authUser 用户信息
     * @return ResultsBean<String>
     */
    @PostMapping(value = "")
    public ResultsBean<String> create(@RequestBody AuthUser authUser) {
        log.info("新建用户 {}", authUser);
        authUserService.create(authUser);
        return ResultsBean.SUCCESS();
    }

    /**
     * 列表查询用户信息
     *
     * @param params 参数
     * @return ResultsBean
     */
    @GetMapping(value = "")
    public ResultsBean<PageInfo<Map<String, Object>>> findByPageAll(@RequestBody Map<String, Object> params) {
        PageInfo<Map<String, Object>> page = authUserService.findByPageAll(params);
        return ResultsBean.SUCCESS(page);
    }

    /**
     * 通过id查询用户信息
     *
     * @param id id
     * @return ResultsBean<AuthUser>
     */
    @GetMapping(value = "/{id}")
    public ResultsBean<AuthUser> findById(@PathVariable("id") Long id) {
        AuthUser authUser = authUserService.findById(id);
        return ResultsBean.SUCCESS(authUser);
    }

    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return ResultsBean<AuthUser>
     */
    @GetMapping(value = "/findByUserName")
    public ResultsBean<AuthUser> findByUserName(@RequestParam("username") String username) {
        AuthUser authUser = authUserService.findByUserName(username);
        return ResultsBean.SUCCESS(authUser);
    }

    /**
     * 通过邮箱查询用户信息
     *
     * @param email 邮箱
     * @return ResultsBean<AuthUser>
     */
    @GetMapping(value = "/findByEmail")
    public ResultsBean<AuthUser> findByEmail(@RequestParam("email") String email) {
        AuthUser authUser = authUserService.findByEmail(email);
        return ResultsBean.SUCCESS(authUser);
    }

}
