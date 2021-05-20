package com.cloud.auth.entity;

import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
/**
 * 权限角色关联
 *
 * @author xulijian
 */
@Data
@Cacheable
@Entity(name = "auth_role_authority")
public class AuthRoleAuthority extends BaseEntity {

    /**
     * 权限id
     */
    private Long authorityId;

    /**
     * 角色Id
     */
    private Long roleId;
}
