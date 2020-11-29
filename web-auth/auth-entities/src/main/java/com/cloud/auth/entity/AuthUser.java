package com.cloud.auth.entity;

import java.util.Date;

import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 用户信息
 */
@Data
@Cacheable
@Entity(name = "auth_user")
public class AuthUser {
    /**
     * 用户ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 角色名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 乐观锁版本
     */
    private Long optimistic;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 更新日期
     */
    private Date updateTime;

    /**
     * 创建日期
     */
    private Date createTime;
}