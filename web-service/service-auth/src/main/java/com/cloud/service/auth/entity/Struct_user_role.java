package com.cloud.service.auth.entity;

import com.cloud.service.auth.base.StructureEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.persistence.*;

import java.io.Serializable;


/**
 * 用户角色关联
 *
 * @author xulijian
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Cacheable
@Entity(name = "struct_user_role")
public class Struct_user_role extends StructureEntity implements Serializable {

    /**
     * 用户Id
     */
    @Column(name = "fk_user")
    private Long fk_user;

    /**
     * 角色id
     */
    @Column(name = "fk_role")
    private Long fk_role;


}