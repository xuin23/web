package com.cloud.sms.provider;

import com.cloud.common.bean.ResultsBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 邮箱服务
 */
@Slf4j
@RestController
@RequestMapping("/cloud/email")
public class EmailProvider {

    @Resource
    private JavaMailSender javaMailSender;

    //todo 待完善
    @RequestMapping("/sendEmail")
    public ResultsBean<String> send() {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //邮件发送人
            simpleMailMessage.setFrom("");
            //邮件接收人
            simpleMailMessage.setTo("");
            //邮件主题
            simpleMailMessage.setSubject("验证码");
            //邮件内容
            simpleMailMessage.setText("123456");
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            log.error("邮件发送失败:{}", e.getMessage());
        }
        return ResultsBean.SUCCESS();
    }

}
