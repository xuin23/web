package com.cloud.entity;

import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
/**
 * 菜单
 *
 * @author xulijian
 */
@Data
@Cacheable
@Entity(name = "auth_menu")
public class AuthMenu extends BaseEntity {

    /**
     * 菜单名
     */
    private String name;

    /**
     * 地址
     */
    private String url;

    /**
     * 菜单父id
     */
    private String pid;
}
