package com.cloud.common.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * 密码加密
 */
public class DigestUtil {

    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * MD5 工具
     *
     * @param str 加密内容s
     * @return 加密结果
     */
    public static String encodeByMd5(String str) {
        byte[] temp = str.getBytes();
        return encodeByMd5(temp);
    }

    /**
     * MD5 工具
     *
     * @param bytes byte数组
     * @return 加密结果
     */
    public static String encodeByMd5(byte[] bytes) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] md = messageDigest.digest();
            char[] chars = new char[md.length * 2];
            int i = 0;
            for (byte byte0 : md) {
                chars[i++] = HEX_CHARS[byte0 >>> 4 & 0xf];
                chars[i++] = HEX_CHARS[byte0 & 0xf];
            }
            return new String(chars);
        } catch (Exception e) {
            return null;
        }
    }
}
