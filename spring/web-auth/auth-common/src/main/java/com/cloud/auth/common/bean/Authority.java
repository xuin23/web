package com.cloud.auth.common.bean;

import com.cloud.common.enums.Status;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限
 *
 * @author xulijian
 */
@Data
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    private Long id;

    /**
     * 乐观锁版本
     */
    private Long optimistic;

    /**
     * 权限名
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
