package com.cloud.auth.entity;

import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
/**
 * 角色信息
 */
@Data
@Cacheable
@Entity(name = "auth_role")
public class AuthRole extends BaseEntity {

    /**
     * 角色名
     */
    private String name;

}
