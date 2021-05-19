package com.cloud.auth.entity;

import com.cloud.common.enums.Status;
import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限操作关联
 *
 * @author xulijian
 */
@Data
@Cacheable
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
     * 乐观锁版本
     */
    @Version
    private Long version;

    /**
     * 状态
     */
    private Status status;

    /**
     * 更新日期
     */
    private Date updateTime;

    /**
     * 创建日期
     */
    private Date createTime;
}
