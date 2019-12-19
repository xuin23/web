package com.cloud.test.jpa.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户信息
 */
@Data
@Entity
public class AuthUser {
    /**
     * 用户ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 乐观锁版本
     */
    @Column
    private Long optimistic;

    /**
     * 角色名
     */
    @Column
    private String username;

    /**
     * 密码
     */
    @Column
    private String password;

    /**
     * 真实姓名
     */
    @Column
    private String realname;

    /**
     * 邮箱
     */
    @Column
    private String email;

    /**
     * 状态
     */
    @Column
    private String status;

    /**
     * 更新日期
     */
    @Column
    private Date updateTime;

    /**
     * 创建日期
     */
    @Column
    private Date createTime;
}