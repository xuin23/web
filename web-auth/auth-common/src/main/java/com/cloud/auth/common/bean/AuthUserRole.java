package com.cloud.auth.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色关联
 *
 * @author xulijian
 */
@Data
public class AuthUserRole implements Serializable {

    /**
     * 权限角色关联id
     */
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
