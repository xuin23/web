package com.cloud.entity;

import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
/**
 * 角色用户组关联
 *
 * @author xulijian
 */
@Data
@Cacheable
@Entity(name = "auth_role_group")
public class AuthRoleGroup extends BaseEntity {

    /**
     * 角色Id
     */
    private Long roleId;

    /**
     * 用户组id
     */
    private Long groupId;
}
