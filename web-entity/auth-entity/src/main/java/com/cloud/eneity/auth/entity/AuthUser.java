package com.cloud.eneity.auth.entity;

import com.cloud.frame.spring.jpa.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


/**
 * 用户信息
 *
 * @author xulijian
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@EntityListeners(value = AuditingEntityListener.class)
@Cacheable
@Entity(name = "auth_user")
public class AuthUser extends BaseEntity {


    private static final String SEQ = "seq_auth_user";

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
     * 用户Id
     */
    @Column(name = "c_id", unique = true)
    private String id;

    /**
     * 角色名
     */
    @Column(name = "c_name")
    private String name;

    /**
     * 密码
     */
    @Column(name = "c_password")
    private String password;

    /**
     * 邮箱
     */
    @Column(name = "c_email")
    private String email;

}