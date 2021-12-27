package com.cloud.eneity.auth.entity;

import com.cloud.frame.spring.jpa.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ColumnDefault;
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

    private static final String SEQ = "seq_auth_user_role";

    /**
     * 主键
     */
    @Id
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
    @ColumnDefault("nextval('" + SEQ + "')")
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
