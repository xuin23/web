package com.cloud.auth.entity;

import com.cloud.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 用户信息
 * 
 * @author xulijian
 */
@Data
@Cacheable
@EntityListeners(value = AuditingEntityListener.class)
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