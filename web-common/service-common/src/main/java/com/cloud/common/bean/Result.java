package com.cloud.common.bean;

import java.io.Serial;
import java.io.Serializable;

/**
 * 公共返回类
 *
 * @param <T> T
 * @author xulijian
 */
public class Result<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 返回成功
     */
    public static final int RESULT_CODE_SUCCESS = 200;

    /**
     * 返回业务失败
     */
    public static final int RESULT_CODE_ERROR = 500;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回信息
     */
    private String message;

    /**
     * 调用时间
     */
    private Long time = System.currentTimeMillis();

    /**
     * 返回对象
     */
    private T object;

    public Result() {
    }

    /**
     * 状态码 实体类
     *
     * @param code   状态码
     * @param object 实体类
     */
    public Result(int code, T object) {
        super();
        this.code = code;
        this.object = object;
    }

    /**
     * 状态码 信息
     * 
     * @param code    状态码
     * @param message 信息
     */
    public Result(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return RESULT_CODE_SUCCESS == code;
    }

    public boolean fail() {
        return RESULT_CODE_SUCCESS != code;
    }

    public static <T> Result<T> SUCCESS(T t) {
        return new Result<T>(RESULT_CODE_SUCCESS, t);
    }

    public static <T> Result<T> SUCCESS() {
        return SUCCESS(null);
    }

    public static <T> Result<T> FAIL(String message) {
        return new Result<T>(RESULT_CODE_ERROR, message);
    }

    public static <T> Result<T> FAIL(int code, String message) {
        return new Result<T>(code, message);
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

    public Long getTime() {
        return this.time;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

}
