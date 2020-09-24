package com.cloud.auth.entity;

import com.cloud.common.enums.Status;
import lombok.Data;

import java.util.Date;

/**
 * 角色信息
 */
@Data
public class AuthRole {

    /**
     * 角色id
     */
    private Long id;

    /**
     * 乐观锁版本
     */
    private Long optimistic;

    /**
     * 角色名
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
