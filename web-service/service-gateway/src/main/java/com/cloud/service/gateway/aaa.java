package com.cloud.service.gateway;

public class aaa {


    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(myAtoi("-2147483648"));
    }

    public static int myAtoi(String s) {
        System.out.println(s.trim());
        char[] chars = s.trim().toCharArray();
        int a = 1;
        int res = 0;
        if (chars.length == 0)
            return 0;
        char char0 = chars[0];
        if (char0 == '-' || char0 == '+') {
            a = char0 == '+' ? 1 : -1;
        } else if (char0 >= '0' && char0 <= 9 + '0') {
            res = char0 - '0';
        } else {
            return res;
        }
        for (int i = 1; i < chars.length; i++) {
            char aChar = chars[i];
            int n = (aChar - '0');
            if (n < 0 || n > 9) {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && n >= Integer.MAX_VALUE % 10)) {
                return a > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + n;
        }
        return res * a;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
        return pre;
    }
}
