package com.cloud.common.common.util;

import java.util.Objects;
import java.util.Random;

/**
 * 验证码工具
 *
 * @author xulijian
 */
public class SecurityCodeUtil {

    public static final String CODE_TYPE_NUM = CodeType.NUM.toString();

    public static final String CODE_TYPE_CH = CodeType.CH.toString();

    /**
     * 验证码类型枚举
     */
    public enum CodeType {
        NUM, //数字
        CH;  //全字符

        public static CodeType getEnum(String type) {
            for (CodeType value : CodeType.values()) {
                if (value.toString().equals(type)) {
                    return value;
                }
            }
            return CodeType.NUM;
        }
    }

    /**
     * 全字符数组
     */
    private static final char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
            'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z'};

    /**
     * 数字数组
     */
    private static final char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * 生成验证码
     *
     * @param length 验证码长度
     * @return 验证码
     */
    public static String generateSecurityCode(int length) {
        return generateSecurityCode(length, CODE_TYPE_NUM);
    }

    /**
     * 生成验证码
     *
     * @param length 验证码长度
     * @param type   验证码类型
     * @return 验证码
     */
    public static String generateSecurityCode(int length, String type) {

        Objects.requireNonNull(type, "Security Code type can not null");

        CodeType codeType = CodeType.getEnum(type);

        char[] c = switch (codeType) {
            case NUM -> num;
            case CH -> ch;
        };
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char st = c[random.nextInt(c.length)];
            sb.append(st);
        }
        return sb.toString();
    }

}
