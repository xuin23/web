package com.cloud.sms.provider;

import com.cloud.common.bean.ResultsBean;
import com.cloud.sms.biz.EmailBiz;
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
    private EmailBiz emailBiz;

    /**
     * 发用邮箱验证码
     *
     * @param username 用户名
     * @return ResultsBean<String>
     */
    @PostMapping("/sendEmail")
    public ResultsBean<String> sendEmail(@RequestParam("username") String username) {
        emailBiz.sendSecurityCode(username);
        return ResultsBean.SUCCESS();
    }

}
