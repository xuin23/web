package com.cloud.common.utils;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DigestUtilTest {

    @Test
    public void encodeByMd5() {
        System.out.println(DigestUtil.encodeByMd5("123456"));
    }

    public static void main(String[] args) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername("postgres");
        dataSource.setPassword("123456");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres?search_path=web");
        dataSource.setMaximumPoolSize(10);
        for (int i = 0; i < 100; i++) {
            new Thread(new ConnectionDemo(dataSource)).start();
        }
    }
}

class ConnectionDemo implements Runnable {

    private HikariDataSource dataSource;

    public ConnectionDemo(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            long t = (long) (Math.random() * 3000);
            System.out.println("获取连接" + Thread.currentThread().getName() + " :sleep" + t);
            Thread.sleep(t);
            connection.close();
            System.out.println("关闭连接" + Thread.currentThread().getName() + " :sleep" + t);
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (null != connection) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}