package com.cloud.auth.entity;

import com.cloud.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * 用户组
 *
 * @author xulijian
 */
@Data
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = AuditingEntityListener.class)
@Cacheable
@Entity(name = "auth_group")
public class AuthGroup extends BaseEntity {

    /**
     * 用户组名
     */
    private String name;

    /**
     * 用户组父id
     */
    private Long fid;
}
