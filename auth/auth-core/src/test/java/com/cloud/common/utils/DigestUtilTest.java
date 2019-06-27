package com.cloud.common.utils;

import org.junit.Test;

public class DigestUtilTest {

    @Test
    public void encodeByMd5() {
        System.out.println(DigestUtil.encodeByMd5("123456"));
    }
}