package com.cloud.common.bean;


import java.io.Serializable;

/**
 * 公共返回类
 *
 * @param <T>
 */
public class ResultsBean<T> implements Serializable {

    //返回成功
    public static final int RESULT_CODE_SUCCESS = 200;
    //返回业务失败
    public static final int RESULT_CODE_SERVICE_ERR = 98;
    //返回系统失败
    public static final int RESULT_CODE_SYSTEM_ERR = 99;

    private int code; // 返回码
    private String message; // 返回信息
    private String failCode; // 错误码
    private T object; // 返回对象

    /**
     * 状态码 实体类
     * @param code
     * @param object
     */
    public ResultsBean(int code, T object) {
        super();
        this.code = code;
        this.object = object;
    }

    public ResultsBean(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ResultsBean(int code, String failCode, String message) {
        super();
        this.code = code;
        this.failCode = failCode;
        this.message = message;
    }

    public boolean success() {
        return RESULT_CODE_SUCCESS == code;
    }

    public boolean fail() {
        return !success();
    }

    public static <T> ResultsBean<T> SUCCESS(T t) {
        return new ResultsBean<T>(RESULT_CODE_SUCCESS, t);
    }

    public static <T> ResultsBean<T> SUCCESS() {
        return SUCCESS(null);
    }

    public static <T> ResultsBean<T> EXCEPTION(String message) {
        return new ResultsBean<T>(RESULT_CODE_SYSTEM_ERR, message);
    }

    public static <T> ResultsBean<T> FAIL(String message) {
        return new ResultsBean<T>(RESULT_CODE_SERVICE_ERR, message);
    }

    public static <T> ResultsBean<T> FAIL(String failCode, String message) {
        return new ResultsBean<T>(RESULT_CODE_SERVICE_ERR, failCode, message);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFailCode() {
        return failCode;
    }

    public void setFailCode(String failCode) {
        this.failCode = failCode;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

}
