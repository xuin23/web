package com.cloud.service.auth.base;


import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity {


    /**
     * 主键
     */
    @Id
//    @SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_pk", unique = true)
//    @ColumnDefault("nextval('" + SEQ + "')")
    private Long c_pk;

}
