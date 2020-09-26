package com.cloud.common.enums;

/**
 * 是否
 *
 * @author xulijian
 */
public enum YesNo {
    Y("是"), N("否");

    private final String value;

    YesNo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
