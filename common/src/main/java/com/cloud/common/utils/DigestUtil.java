package com.cloud.common.utils;

import com.cloud.common.enums.EncodeType;

import java.security.MessageDigest;

/**
 * 密码加密
 */
public class DigestUtil {

    public static final String ENCODE = "UTF-8";
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * MD5 加密
     *
     * @param str 加密内容s
     * @return 加密结果
     */
    public static String encodeByMd5(String str) {
        try {
            byte[] strTemp = str.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance(EncodeType.MD5.toString());

            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] string = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                string[k++] = HEX_CHARS[byte0 >>> 4 & 0xf];
                string[k++] = HEX_CHARS[byte0 & 0xf];
            }
            return new String(string);
        } catch (Exception e) {
            return null;
        }
    }
}
