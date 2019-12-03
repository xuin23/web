package com.cloud.common.utils;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DigestUtilTest {

    @Test
    public void encodeByMd5() {
        System.out.println(DigestUtil.encodeByMd5("123456"));
    }

    @Test
    public void image() throws IOException {
        File file1 = new File("C:\\Users\\xx\\Desktop\\批注 2019-11-25 204937 - 副本.png");
        File file2 = new File("C:\\Users\\xx\\Desktop\\批注 2019-11-25 204937.png");
        FileInputStream fileInputStream1 = new FileInputStream(file1);
        FileInputStream fileInputStream2 = new FileInputStream(file2);
        byte[] b1 = fileInputStream1.readAllBytes();
        System.out.println(b1.length);
        byte[] b2 = fileInputStream2.readAllBytes();
        System.out.println(b2.length);
        long timeMillis = System.currentTimeMillis();

        StringBuffer s1 = new StringBuffer();
        for (byte b : b1) {
            s1.append(b);
        }
//        System.out.println(s1);
        System.out.println(System.currentTimeMillis() - timeMillis + " 毫秒");
        timeMillis = System.currentTimeMillis();
        StringBuffer s2 = new StringBuffer();
        for (byte b : b2) {
            s2.append(b);
        }
//        System.out.println(s2);
        System.out.println(System.currentTimeMillis() - timeMillis + " 毫秒");

        timeMillis = System.currentTimeMillis();
        System.out.println(DigestUtil.encodeByMd5(s1.toString()));
        System.out.println(System.currentTimeMillis() - timeMillis + " md5毫秒");

        timeMillis = System.currentTimeMillis();
        System.out.println(DigestUtil.encodeByMd5(s2.toString()));
        System.out.println(System.currentTimeMillis() - timeMillis + " md5毫秒");


        timeMillis = System.currentTimeMillis();
        if (s1.equals(s2)) {
            System.out.println("asd");
        }
        System.out.println(System.currentTimeMillis() - timeMillis + " md5毫秒");

    }
}