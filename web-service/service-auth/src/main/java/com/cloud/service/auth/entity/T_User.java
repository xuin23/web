package com.cloud.service.auth.entity;

import com.cloud.service.auth.base.TableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;


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
@Entity(name = "t_user")
public class T_User extends TableEntity {


    /**
     * 主键
     */
    @Column(name = "c_id", unique = true)
    private String c_id;

    /**
     * 角色名
     */
    @Column(name = "c_name")
    private String c_name;

    /**
     * 密码
     */
    @Column(name = "c_password")
    private String c_password;

    /**
     * 邮箱
     */
    @Column(name = "c_email")
    private String c_email;

//
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(name = "structure_user_role", joinColumns = @JoinColumn(name = "c_id"), inverseJoinColumns = @JoinColumn(name = "fk_user"))
//    private List<UserRole> userRoles;

}