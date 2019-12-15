package com.cloud.auth.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 角色用户组关联
 *
 * @author xulijian
 */
@Data
@Entity(name = "auth_role_group")
public class AuthRoleGroup {

    /**
     * 权限角色关联id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 角色Id
     */
    private Long roleId;

    /**
     * 用户组id
     */
    private Long groupId;

    /**
     * 创建日期
     */
    private Date createTime;
}
