package com.cloud.eneity.auth.entity;

import com.cloud.frame.spring.jpa.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
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


    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "table_auth_role_seq")
    @Column(name = "c_pk", unique = true)
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
