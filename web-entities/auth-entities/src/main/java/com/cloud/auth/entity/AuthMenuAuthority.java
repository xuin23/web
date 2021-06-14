package com.cloud.auth.entity;

import com.cloud.common.entity.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * 权限菜单关联
 *
 * @author xulijian
 */
@Data
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = AuditingEntityListener.class)
@Cacheable
@Entity(name = "AUTH_MENU_AUTHORITY")
public class AuthMenuAuthority extends BaseEntity {

    /**
     * 权限id
     */
    private Long authorityId;

    /**
     * 菜单Id
     */
    private Long menuId;
}
