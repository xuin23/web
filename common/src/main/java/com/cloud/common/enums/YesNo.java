package com.cloud.common.enums;


/**
 * 是否
 */
public enum YesNo {
    Y("Y", "Y"),
    N("N", "N");

    private String code;
    private String value;

    private YesNo(String code, String value) {
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
