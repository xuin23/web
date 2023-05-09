package com.cloud.service.auth.entity;

import com.cloud.frame.spring.jpa.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


/**
 * 角色信息
 */
@Data
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = AuditingEntityListener.class)
@Cacheable
@Entity(name = "auth_role")
public class AuthRole extends BaseEntity {

    private static final String SEQ = "seq_auth_role";

    /**
     * 主键
     */
    @Id
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
    @Column(name = "c_pk", unique = true)
    @ColumnDefault("nextval('" + SEQ + "')")
    private Long pk;

    /**
     * 角色id
     */
    @Column(name = "c_id", unique = true)
    private String id;

    /**
     * 角色名
     */
    @Column(name = "c_name")
    private String name;

}
