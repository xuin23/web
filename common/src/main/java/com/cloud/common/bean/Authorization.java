package com.cloud.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 登录认证信息
 */
@Data
public class Authorization implements Serializable {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 角色名
     */
    private String username;

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
