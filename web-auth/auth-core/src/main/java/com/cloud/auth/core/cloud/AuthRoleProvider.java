package com.cloud.auth.core.cloud;

import com.cloud.auth.core.biz.AuthRoleBiz;
import com.cloud.auth.core.biz.AuthUserBiz;
import com.cloud.auth.core.service.AuthRoleService;
import com.cloud.auth.entity.AuthRole;
import com.cloud.auth.entity.AuthUser;
import com.cloud.common.bean.ResultsBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 角色 provider
 */
@Slf4j
@RestController
@RequestMapping(value = "/cloud/authRole")
public class AuthRoleProvider {

    /**
     * 用户 service
     */
    @Resource
    private AuthRoleService authRoleService;

    /**
     * 用户 业务
     */
    @Resource
    private AuthRoleBiz authRoleBiz;

    /**
     * 通过id删除角色信息
     *
     * @param id id
     * @return ResultsBean<String>
     */
    @DeleteMapping(value = "/deleteById/{id}")
    public ResultsBean<String> deleteById(@PathVariable("id") Long id) {
        log.info("用户信息删除 ID={}", id);
        authRoleService.deleteById(id);
        return ResultsBean.SUCCESS();
    }

    /**
     * 修改或添加角色信息
     *
     * @param authRole 角色信息
     * @return ResultsBean<String>
     */
    @PostMapping(value = "/merge")
    public ResultsBean<String> merge(@RequestBody AuthRole authRole) {
        authRoleBiz.merge(authRole);
        return ResultsBean.SUCCESS();
    }


}
