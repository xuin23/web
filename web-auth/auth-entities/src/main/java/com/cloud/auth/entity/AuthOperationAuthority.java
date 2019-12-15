package com.cloud.auth.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 权限操作关联
 *
 * @author xulijian
 */
@Data
@Entity(name = "auth_operation_authority")
public class AuthOperationAuthority implements Serializable {

    /**
     * 权限操作关联id
     */
    @Id
    @GeneratedValue
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
