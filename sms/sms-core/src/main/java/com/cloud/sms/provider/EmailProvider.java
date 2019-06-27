package com.cloud.sms.provider;

import com.cloud.common.bean.ResultsBean;
import com.cloud.sms.biz.EmailBiz;
import com.cloud.sms.common.bean.EmailBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    private EmailBiz emailBiz;

    /**
     * 发用邮箱验证码
     *
     * @param email 邮箱
     * @return
     */
    @GetMapping("/sendEmail")
    public ResultsBean<String> sendEmail(@RequestParam("email") String email) {
        emailBiz.sendSecurityCode(email);
        return ResultsBean.SUCCESS();
    }

}
