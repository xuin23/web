package com.cloud.service.auth.entity;

import com.cloud.frame.spring.jpa.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
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
    @Column(name = "c_id", unique = true)
    @ColumnDefault("nextval('" + SEQ + "')")
    @Getter
    private Long id;

    /**
     * 角色id
     */
    @Column(name = "c_rid")
    private String rid;

    /**
     * 角色名
     */
    @Column(name = "c_name")
    private String name;

}
