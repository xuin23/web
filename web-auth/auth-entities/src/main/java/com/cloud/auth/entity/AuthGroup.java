package com.cloud.auth.entity;

import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
/**
 * 用户组
 *
 * @author xulijian
 */
@Data
@Cacheable
@Entity(name = "auth_group")
public class AuthGroup extends BaseEntity {

    /**
     * 用户组名
     */
    private String name;

    /**
     * 用户组父id
     */
    private Long fid;
}
