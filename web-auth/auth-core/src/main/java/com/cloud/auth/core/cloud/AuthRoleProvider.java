package com.cloud.auth.core.cloud;

import com.cloud.auth.core.service.AuthRoleService;
import com.cloud.auth.entity.AuthRole;
import com.cloud.common.bean.ResultsBean;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

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
     * 列表查询角色信息
     *
     * @param params 参数
     * @return ResultsBean
     */
    @GetMapping(value = "")
    public ResultsBean<PageInfo<Map<String, Object>>> findByPageAll(@RequestBody Map<String, Object> params) {
        log.info("params:{}", params);
        PageInfo<Map<String, Object>> page = authRoleService.findByPageAll(params);
        return ResultsBean.SUCCESS(page);
    }

    /**
     * 通过id查询用户信息
     *
     * @param id id
     * @return ResultsBean<AuthUser>
     */
    @GetMapping(value = "/{id}")
    public ResultsBean<AuthRole> findById(@PathVariable("id") Long id) {
        log.info("id:{}", id);
        AuthRole authRole = authRoleService.findById(id);
        return ResultsBean.SUCCESS(authRole);
    }

    /**
     * 通过id删除角色信息
     *
     * @param id id
     * @return ResultsBean<String>
     */
    @DeleteMapping(value = "/{id}")
    public ResultsBean<String> deleteById(@PathVariable("id") Long id) {
        log.info("id:{}", id);
        authRoleService.deleteById(id);
        return ResultsBean.SUCCESS();
    }

    /**
     * 根据id修改角色信息
     *
     * @param authRole 角色信息
     * @return ResultsBean<String>
     */
    @PutMapping(value = "")
    public ResultsBean<String> updateById(@RequestBody AuthRole authRole) {
        if (null != authRole.getId()) {
            log.info("用户信息更新{}", authRole);
            authRoleService.modifyById(authRole, authRole.getId());
        }
        return ResultsBean.SUCCESS();
    }

    /**
     * 创建角色信息
     *
     * @param authRole 角色信息
     * @return ResultsBean<String>
     */
    @PostMapping(value = "")
    public ResultsBean<String> create(@RequestBody AuthRole authRole) {
        log.info("新建用户 {}", authRole);
        authRoleService.create(authRole);
        return ResultsBean.SUCCESS();
    }


}
