package com.cloud.auth.core.cloud;

import com.cloud.common.bean.ResultsBean;
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
    public ResultsBean<Object> defaultErrorHandler(Exception e) {
        log.error("", e);
        return ResultsBean.SUCCESS(e.getMessage());
    }
}
