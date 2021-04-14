package com.cloud.auth.config;

import com.cloud.common.bean.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 默认异常处理
     *
     * @param e   异常
     * @return ResultsBean<Object>
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultBean<Object> defaultErrorHandler(Exception e) {
        log.error("", e);
        return ResultBean.FAIL(e.getMessage());
    }
}
