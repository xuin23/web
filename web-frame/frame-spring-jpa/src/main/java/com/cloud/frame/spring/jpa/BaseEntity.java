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
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "pk")
    private Long pk;

    /**
     * 版本
     */
    @Version
    @Column(name = "version")
    @ColumnDefault("0")
    private Long version;

    /**
     * 状态
     */
    @Column(name = "status")
    @ColumnDefault("true")
    private Boolean status;

    /**
     * 更新日期
     */
    @LastModifiedDate
    @Column(name = "update_Time")
    @ColumnDefault("NOW()")
    private Date updateTime;

    /**
     * 创建日期
     */
    @CreatedDate
    @Column(name = "create_Time")
    @ColumnDefault("NOW()")
    private Date createTime;

}
