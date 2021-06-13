package com.cloud.entity;

import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
/**
 * 用户角色关联
 *
 * @author xulijian
 */
@Data
@Cacheable
@Entity(name = "auth_user_role")
public class AuthUserRole extends BaseEntity{

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

}
