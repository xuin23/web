package com.cloud.auth.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限角色关联
 *
 * @author xulijian
 */
@Data
public class AuthRoleAuthority implements Serializable {

    /**
     * 权限角色关联id
     */
    private Long id;

    /**
     * 权限id
     */
    private Long authorityId;

    /**
     * 角色Id
     */
    private Long roleId;

    /**
     * 创建日期
     */
    private Date createTime;
}
