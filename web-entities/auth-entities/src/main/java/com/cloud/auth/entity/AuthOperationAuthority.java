package com.cloud.auth.entity;

import com.cloud.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * 权限操作关联
 *
 * @author xulijian
 */
@Data
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = AuditingEntityListener.class)
@Cacheable
@Entity(name = "auth_operation_authority")
public class AuthOperationAuthority extends BaseEntity {

    /**
     * 功能Id
     */
    private Long operationId;

    /**
     * 权限id
     */
    private Long authorityId;
}
