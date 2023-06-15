package com.cloud.frame.spring.common;

import com.cloud.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author xulijian
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    public GlobalExceptionHandler() {
        log.info("GlobalExceptionHandler Init");
    }

    /**
     * 默认异常处理
     *
     * @param e 异常
     * @return ResultsBean<Object>
     * @author xulijian
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result<Object> defaultErrorHandler(Exception e) {
        log.error("", e);
        return Result.FAIL(e.getMessage());
    }
}
