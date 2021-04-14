package com.cloud.auth.entity;

import com.cloud.common.enums.Status;
import lombok.Data;

import javax.persistence.Cacheable;
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
@Cacheable
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
     * 乐观锁版本
     */
    private Long optimistic;

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
