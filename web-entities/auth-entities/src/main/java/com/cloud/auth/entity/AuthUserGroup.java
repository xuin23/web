package com.cloud.auth.entity;

import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

/**
 * 用户用户组关联
 *
 * @author xulijian
 */
@Data
@Cacheable
@Entity(name = "auth_user_group")
public class AuthUserGroup extends BaseEntity {

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 用户组id
     */
    private Long groupId;
}
