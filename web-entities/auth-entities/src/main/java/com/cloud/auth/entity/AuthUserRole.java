package com.cloud.auth.entity;

import com.cloud.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


/**
 * 用户角色关联
 *
 * @author xulijian
 */
@Data
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = AuditingEntityListener.class)
@Cacheable
@Entity(name = "auth_user_role")
public class AuthUserRole extends BaseEntity {

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;


    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private AuthUser authUser;


    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private AuthRole authRole;
}
