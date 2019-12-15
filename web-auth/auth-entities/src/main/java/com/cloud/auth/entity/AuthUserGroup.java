package com.cloud.auth.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户用户组关联
 *
 * @author xulijian
 */
@Data
@Entity(name = "auth_user_group")
public class AuthUserGroup {

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
     * 用户组id
     */
    private Long groupId;

    /**
     * 创建日期
     */
    private Date createTime;
}
