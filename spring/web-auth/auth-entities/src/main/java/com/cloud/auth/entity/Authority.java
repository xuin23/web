package com.cloud.auth.entity;

import com.cloud.common.enums.Status;
import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 权限
 *
 * @author xulijian
 */
@Data
@Cacheable
@Entity(name = "authority")
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 权限名
     */
    private String name;

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
