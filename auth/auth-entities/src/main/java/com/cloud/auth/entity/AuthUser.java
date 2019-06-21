package com.cloud.auth.entity;

import java.util.Date;

import com.cloud.auth.common.enums.Status;
import lombok.Data;

/**
 * 用户信息
 */
@Data
public class AuthUser {
    /**
     * 用户ID
     */
    private Long id;

    /**
     * 乐观锁版本
     */
    private Long optimistic;

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
     * 状态
     */
    private Status status;

    /**
     * 更新日期
     */
    private Date updateTime;

    /**
     * 创建日期
     */
    private Date createTime;
}