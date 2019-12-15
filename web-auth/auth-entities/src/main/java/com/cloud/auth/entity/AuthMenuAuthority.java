package com.cloud.auth.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 权限菜单关联
 *
 * @author xulijian
 */
@Data
@Entity(name = "auth_menu_authority")
public class AuthMenuAuthority implements Serializable {

    /**
     * 权限菜单关联id
     */
    @Id
    @GeneratedValue
    private Long id;


    /**
     * 权限id
     */
    private Long authorityId;

    /**
     * 菜单Id
     */
    private Long menuId;

    /**
     * 创建日期
     */
    private Date createTime;
}
