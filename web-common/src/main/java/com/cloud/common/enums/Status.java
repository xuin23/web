package com.cloud.common.enums;


/**
 * 状态
 */
public enum Status {

    TRUE("有效"),
    FALSE("无效");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
