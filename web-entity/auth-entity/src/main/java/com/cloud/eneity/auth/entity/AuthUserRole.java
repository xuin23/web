package com.cloud.eneity.auth.entity;

import com.cloud.frame.spring.jpa.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


/**
 * 用户角色关联
 *
 * @author xulijian
 */
@Data
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = AuditingEntityListener.class)
@Cacheable
@Entity(name = "auth_user_role")
public class AuthUserRole extends BaseEntity {


    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "table_auth_user_role_seq")
    @Column(name = "c_pk", unique = true)
    private Long pk;

    /**
     * 用户Id
     */
    @Column(name = "fk_user")
    private Long fkUser;

    /**
     * 角色id
     */
    @Column(name = "fk_role")
    private Long fkRole;

}
