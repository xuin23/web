package com.cloud.auth.entity;

import com.cloud.common.enums.Status;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 菜单
 *
 * @author xulijian
 */
@Data
@Entity(name = "auth_menu")
public class AuthMenu implements Serializable {

    /**
     * 菜单id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 乐观锁版本
     */
    private Long optimistic;

    /**
     * 菜单名
     */
    private String name;

    /**
     * 地址
     */
    private String url;

    /**
     * 菜单父id
     */
    private String pid;

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
