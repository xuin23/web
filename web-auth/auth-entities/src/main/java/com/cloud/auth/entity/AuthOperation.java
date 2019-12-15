package com.cloud.auth.entity;

import com.cloud.common.enums.Status;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 功能操作
 *
 * @author xulijian
 */
@Data
@Entity(name = "auth_operation")
public class AuthOperation implements Serializable {

    /**
     * 功能id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 乐观锁版本
     */
    private Long optimistic;

    /**
     * 功能名
     */
    private String name;

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
