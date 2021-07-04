package com.cloud.auth.entity;

import com.cloud.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;


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

    /**
     * 角色名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 邮箱
     */
    private String email;

}