package com.cloud.auth.entity;

import com.cloud.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

/**
 * 权限
 *
 * @author xulijian
 */
@Data
@Cacheable
@Entity(name = "authority")
public class Authority extends BaseEntity {

    /**
     * 权限名
     */
    private String name;
}
