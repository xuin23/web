package com.cloud.auth.entity;

import com.cloud.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * 菜单
 *
 * @author xulijian
 */
@Data
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = AuditingEntityListener.class)
@Cacheable
@Entity(name = "auth_menu")
public class AuthMenu extends BaseEntity {

    /**
     * 菜单名
     */
    private String name;

    /**
     * 地址
     */
    private String url;

    /**
     * 菜单父id
     */
    private String pid;
}
