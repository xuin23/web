package com.cloud.auth.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户bean
 */
@Data
public class AuthUserBean implements Serializable {

    /**
     * 用户ID
     */
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
     * 状态
     */
    private String status;

    /**
     * 创建日期
     */
    private Date createTime;
}
