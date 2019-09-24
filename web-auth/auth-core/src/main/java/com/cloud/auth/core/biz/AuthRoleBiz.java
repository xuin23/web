package com.cloud.auth.core.biz;


import com.cloud.auth.entity.AuthRole;

/**
 * 角色 业务
 */
public interface AuthRoleBiz {

    /**
     * 修改或添加角色信息
     *
     * @param authRole 角色信息
     */
    void merge(AuthRole authRole);

}
