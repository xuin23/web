package com.cloud.frame.spring.common;

import com.cloud.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 全局异常处理
 *
 * @author xulijian
 */
@Slf4j
@Component
@ControllerAdvice
public class RequestHandler {

    public RequestHandler() {
        log.info("RequestHandler Init");
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
    public Result<Object> exceptionHandler(Exception e) {
        log.error("", e);
        return Result.FAIL(e.getMessage());
    }

    /**
     * dataBinder
     *
     * @param binder WebDataBinder
     * @author xulijian
     */
    @InitBinder
    public void dataBinder(WebDataBinder binder) {
//        DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
//        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat1, true);
//        DateFormat dateFormat2 = new SimpleDateFormat("MMM d, YYYY");
//        CustomDateEditor shipDateEditor = new CustomDateEditor(dateFormat2, true);
//        binder.registerCustomEditor(Date.class, "orderDate", orderDateEditor);
//        binder.registerCustomEditor(Date.class, "shipDate", shipDateEditor);
    }

}
