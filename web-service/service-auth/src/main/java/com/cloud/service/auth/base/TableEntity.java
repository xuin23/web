package com.cloud.service.auth.base;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基础数据(存储非业务操作数据)
 *
 * @author xulijian
 * @since 20210823
 */
@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public abstract class TableEntity extends BaseEntity {


    /**
     * 修订
     */
    @Version
    @Column(name = "c_revision")
    private Integer c_revision;

    /**
     * 更新日期
     */
    @LastModifiedDate
    @Column(name = "c_update")
    @ColumnDefault("now()")
    private Date c_update;

    /**
     * 更新人
     */
    @Column(name = "c_updated")
    @LastModifiedBy
    private String c_updated;

    /**
     * 创建日期
     */
    @CreatedDate
    @Column(name = "c_create")
    @ColumnDefault("now()")
    private Date c_create;

    /**
     * 创建人
     */
    @Column(name = "c_created", updatable = false, insertable = false)
    @CreatedBy
    private String c_created;


}
