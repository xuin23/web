package com.cloud.common.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * 实体类基础数据
 *
 * @author xulijian
 */
@Data
@MappedSuperclass
public class BaseEntity {

    /**
     * 权限菜单关联id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * 版本
     */
    @Version
    @Column(name = "version")
    private Integer version = 0;

    /**
     * 状态
     */
    @Column(name = "status")
    private Boolean status = true;

    /**
     * 更新日期
     */
    @LastModifiedDate
    @Column(name = "update_Time")
    private Date updateTime;

    /**
     * 创建日期
     */
    @CreatedDate
    @Column(name = "create_Time")
    private Date createTime;

}
