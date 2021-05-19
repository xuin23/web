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
 * 菜单
 *
 * @author xulijian
 */
@Data
@Cacheable
@Entity(name = "auth_menu")
public class AuthMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
     */
    @Id
    @GeneratedValue
    private Long id;

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
