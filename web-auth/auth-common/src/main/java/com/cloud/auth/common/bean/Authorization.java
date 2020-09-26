package com.cloud.auth.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 登录认证信息
 */
@Data
public class Authorization implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 角色名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * token
     */
    private String token;

    /**
     * 菜单
     */
    private List<String> menus;
}
