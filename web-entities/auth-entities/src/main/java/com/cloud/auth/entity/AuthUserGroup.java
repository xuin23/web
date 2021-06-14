package com.cloud.auth.entity;

import com.cloud.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;


/**
 * 用户用户组关联
 *
 * @author xulijian
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Cacheable
@Entity(name = "auth_user_group")
public class AuthUserGroup extends BaseEntity {

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 用户组id
     */
    private Long groupId;
}
