package com.cloud.service.auth.base;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基础数据(存储非业务操作数据)
 *
 * @author xulijian
 * @since 20210823
 */
@Data
@MappedSuperclass
public abstract class StructureEntity extends BaseEntity {

}
