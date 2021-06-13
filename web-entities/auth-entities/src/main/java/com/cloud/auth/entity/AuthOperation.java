package com.cloud.auth.entity;

import com.cloud.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
/**
 * 功能操作
 *
 * @author xulijian
 */
@Data
@Cacheable
@Entity(name = "auth_operation")
public class AuthOperation extends BaseEntity {

    /**
     * 功能名
     */
    private String name;
}
