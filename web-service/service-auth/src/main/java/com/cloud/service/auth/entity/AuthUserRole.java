package com.cloud.service.auth.entity;

import com.cloud.frame.spring.jpa.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.*;
import java.io.Serializable;


/**
 * 用户角色关联
 *
 * @author xulijian
 */
@Data
@Entity(name = "auth_user_role")
public class AuthUserRole extends BaseEntity implements Serializable {

    private static final String SEQ = "seq_auth_user_role";

    /**
     * 主键
     */
    @Id
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
    @ColumnDefault("nextval('" + SEQ + "')")
    @Column(name = "c_id", unique = true)
    private Long c_id;

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
