package com.cloud.auth.common.bean;

import lombok.Data;
import com.cloud.common.enums.Status;


import java.io.Serializable;
import java.util.Date;

/**
 * 角色
 *
 * @author xulijian
 */
@Data
public class AuthRole implements Serializable {

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
