package com.cloud.auth.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 权限角色关联
 *
 * @author xulijian
 */
@Data
@Entity(name = "auth_role_authority")
public class AuthRoleAuthority {

    /**
     * 权限角色关联id
     */
    @Id
    @GeneratedValue
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
