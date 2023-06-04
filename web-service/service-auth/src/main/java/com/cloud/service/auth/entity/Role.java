package com.cloud.service.auth.entity;

import com.cloud.service.auth.base.TableEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


/**
 * 角色信息
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@EntityListeners(value = AuditingEntityListener.class)
@Cacheable
@Entity(name = "t_role")
public class Role extends TableEntity {

    /**
     * 主键
     */
    @Column(name = "c_id", unique = true, nullable = false)
    private String c_id;

    /**
     * 角色名
     */
    @Column(name = "c_name")
    private String c_name;



}
