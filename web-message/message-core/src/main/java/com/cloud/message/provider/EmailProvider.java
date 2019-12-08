package com.cloud.message.provider;

import com.cloud.common.bean.ResultsBean;
import com.cloud.message.biz.IEmailBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 邮箱服务
 */
@Slf4j
@RestController
@RequestMapping("/cloud/email")
public class EmailProvider {

    /**
     * 邮箱业务
     */
    @Resource
    private IEmailBiz emailBiz;

    /**
     * 发用邮箱验证码
     *
     * @param username 用户名
     * @return ResultsBean<String>
     */
    @PostMapping("/sendEmail")
    public ResultsBean<String> sendEmail(@RequestParam("username") String username) {
        try {
            emailBiz.sendSecurityCode(username);
        } catch (Exception e) {
            log.error("发送邮箱验证码出错,{}", e.getMessage(), e);
        }
        return ResultsBean.SUCCESS();
    }

}
