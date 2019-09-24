package com.cloud.auth.core.cloud.query;

import com.cloud.auth.core.service.AuthRoleService;
import com.cloud.auth.entity.AuthRole;
import com.cloud.common.bean.ResultsBean;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 角色查询 provider
 */
@Slf4j
@RestController
@RequestMapping(value = "/cloud/authRoleQuery")
public class AuthRoleQueryProvider {

    /**
     * 角色 service
     */
    @Resource
    private AuthRoleService authRoleService;

    /**
     * 列表查询角色信息
     *
     * @param params 参数
     * @return ResultsBean
     */
    @GetMapping(value = "/findByPageAll")
    public ResultsBean<PageInfo<Map<String, Object>>> findByPageAll(@RequestBody Map<String, Object> params) {
        PageInfo<Map<String, Object>> page = authRoleService.findByPageAll(params);
        return ResultsBean.SUCCESS(page);
    }

    /**
     * 通过id查询用户信息
     *
     * @param id id
     * @return ResultsBean<AuthUser>
     */
    @GetMapping(value = "/findById/{id}")
    public ResultsBean<AuthRole> findById(@PathVariable("id") Long id) {
        AuthRole authRole = authRoleService.findById(id);
        return ResultsBean.SUCCESS(authRole);
    }

}