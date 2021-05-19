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
 * 用户组
 *
 * @author xulijian
 */
@Data
@Cacheable
@Entity(name = "auth_group")
public class AuthGroup implements Serializable {

    /**
     * 用户组id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 用户组名
     */
    private String name;

    /**
     * 用户组父id
     */
    private Long fid;

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
