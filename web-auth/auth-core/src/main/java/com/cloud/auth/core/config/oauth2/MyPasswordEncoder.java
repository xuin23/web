package com.cloud.auth.core.config.oauth2;

import com.cloud.common.utils.DigestUtil;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SpringSecurity 自定义加密
 */
public class MyPasswordEncoder implements PasswordEncoder {

    /**
     * 密码加密
     *
     * @param charSequence 密码
     * @return String
     */
    @Override
    public String encode(CharSequence charSequence) {
        return DigestUtil.encodeByMd5(charSequence.toString());
    }

    /**
     * 验证密码是否正确
     *
     * @return boolean
     */
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return encode(charSequence).equals(s);
    }
}
