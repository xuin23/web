package com.cloud.auth.common.enums;


/**
 * 状态
 */
public enum Status {

    TRUE("TRUE", "有效"),
    FALSE("FALSE", "无效");

    private String code;
    private String value;

    private Status(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
