package com.cloud.auth.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户角色关联
 *
 * @author xulijian
 */
@Data
@Entity(name = "auth_user_role")
public class AuthUserRole {

    /**
     * 权限角色关联id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 创建日期
     */
    private Date createTime;
}
