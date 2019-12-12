package com.cloud.auth.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限操作关联
 *
 * @author xulijian
 */
@Data
public class AuthOperationAuthority implements Serializable {

    /**
     * 权限操作关联id
     */
    private Long id;

    /**
     * 功能Id
     */
    private Long operationId;

    /**
     * 权限id
     */
    private Long authorityId;

    /**
     * 创建日期
     */
    private Date createTime;
}
