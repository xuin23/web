package com.cloud.test.jpa.config;

import com.cloud.common.bean.ResultsBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 全局异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {



    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultsBean defaultErrorHandler(HttpServletRequest req, Exception e) {
        Map<String, String[]> reqMap = req.getParameterMap();
        for (String s : reqMap.keySet()) {
            String[] strings = reqMap.get(s);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        if (null != req) {
            try {
                log.info("请求参数 {}", objectMapper.writeValueAsString(reqMap));
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
        }
        log.error("", e);
        return ResultsBean.SUCCESS(req.getParameterMap());
    }
}
