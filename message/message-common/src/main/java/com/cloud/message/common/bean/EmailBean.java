package com.cloud.message.common.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 邮箱实体类
 */
@Data
public class EmailBean implements Serializable {

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
