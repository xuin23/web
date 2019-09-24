package com.cloud.common.enums;

/**
 * 加密方法
 */
public enum EncodeType {
    MD5("MD5");

    private String value;

    EncodeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
