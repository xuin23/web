package com.cloud.auth.entity;

import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
/**
 * 权限菜单关联
 *
 * @author xulijian
 */
@Data
@Cacheable
@Entity(name = "AUTH_MENU_AUTHORITY")
public class AuthMenuAuthority extends BaseEntity {

    /**
     * 权限id
     */
    private Long authorityId;

    /**
     * 菜单Id
     */
    private Long menuId;
}
