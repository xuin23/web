package com.cloud.common.message.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 邮箱实体类
 */
@Data
public class EmailModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 邮箱发送人
     */
    private String from;

    /**
     * 邮箱接收人
     */
    private String to;

    /**
     * 邮箱主题
     */
    private String subject;

    /**
     * 邮箱内容
     */
    private String text;
}
