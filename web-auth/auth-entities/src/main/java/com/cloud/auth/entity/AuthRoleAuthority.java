package com.cloud.auth.entity;

import com.cloud.common.enums.Status;
import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import java.util.Date;

/**
 * 权限角色关联
 *
 * @author xulijian
 */
@Data
@Cacheable
@Entity(name = "auth_role_authority")
public class AuthRoleAuthority {

    /**
     * 权限角色关联id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 权限id
     */
    private Long authorityId;

    /**
     * 角色Id
     */
    private Long roleId;

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
