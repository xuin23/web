package com.cloud.auth.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色用户组关联
 *
 * @author xulijian
 */
@Data
public class AuthRoleGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限角色关联id
     */
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
