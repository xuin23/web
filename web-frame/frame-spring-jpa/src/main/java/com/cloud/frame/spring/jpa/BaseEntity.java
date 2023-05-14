package com.cloud.frame.spring.jpa;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import java.util.Date;

/**
 * 实体类基础数据(存储非业务操作数据)
 *
 * @author xulijian
 * @since 20210823
 */
@Data
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public class BaseEntity {

    /**
     * 修订
     */
    @Version
    @Column(name = "c_revision")
    private Long revision;

    /**
     * 更新日期
     */
    @LastModifiedDate
    @Column(name = "c_update")
    @ColumnDefault("now()")
    private Date update;

    /**
     * 更新人
     */
    @Column(name = "c_updated")
    @LastModifiedBy
    private String updated;

    /**
     * 创建日期
     */
    @CreatedDate
    @Column(name = "c_create")
    @ColumnDefault("now()")
    private Date create;

    /**
     * 创建人
     */
    @Column(name = "c_create", updatable = false, insertable = false)
    @CreatedBy
    private String created;


}
