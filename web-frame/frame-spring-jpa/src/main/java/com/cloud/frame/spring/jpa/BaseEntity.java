package com.cloud.frame.spring.jpa;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 实体类基础数据(存储非业务操作数据)
 *
 * @author xulijian
 */
@Data
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public class BaseEntity {

    /**
     * 版本
     */
    @Version
    @Column(name = "c_version")
    @ColumnDefault("1")
    private Long version;

    /**
     * 状态
     */
    @Column(name = "c_status")
    @ColumnDefault("true")
    private Boolean status;

    /**
     * 更新日期
     */
    @LastModifiedDate
    @Column(name = "c_update")
    @ColumnDefault("now()")
    private Date update;

    /**
     * 创建日期
     */
    @CreatedDate
    @Column(name = "c_create")
    @ColumnDefault("now()")
    private Date create;

}
