package com.cloud.auth.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户用户组关联
 *
 * @author xulijian
 */
@Data
public class AuthUserGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限角色关联id
     */
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
