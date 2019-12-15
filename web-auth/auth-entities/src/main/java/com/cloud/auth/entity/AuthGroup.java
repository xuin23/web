package com.cloud.auth.entity;

import com.cloud.common.enums.Status;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户组
 *
 * @author xulijian
 */
@Data
@Entity(name = "auth_user")
public class AuthGroup implements Serializable {

    /**
     * 用户组id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 乐观锁版本
     */
    private Long optimistic;

    /**
     * 用户组名
     */
    private String name;

    /**
     * 用户组父id
     */
    private Long fid;

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
