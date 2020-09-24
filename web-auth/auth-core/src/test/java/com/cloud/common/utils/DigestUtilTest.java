package com.cloud.common.utils;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DigestUtilTest {

    @Test
    public void encodeByMd5() {
        System.out.println(DigestUtil.encodeByMd5("123456"));
    }

    public static void main(String[] args) throws InterruptedException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername("postgres");
        dataSource.setPassword("123456");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres?search_path=web");
        dataSource.setMaximumPoolSize(100);
        List<Thread> threadList = new ArrayList<>();
        long t = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new ConnectionDemo(dataSource));
            threadList.add(thread);
            thread.start();
        }
        for (Thread thread : threadList) {
            thread.join();
        }
        System.out.println(System.currentTimeMillis() - t);
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
    }
}

class ConnectionDemo implements Runnable {

    private final HikariDataSource dataSource;

    public ConnectionDemo(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run() {
        Connection connection = null;
        try {
            synchronized (dataSource) {
                connection = dataSource.getConnection();
                long t = (long) (Math.random() * 3000);
                System.out.println("获取连接" + Thread.currentThread().getName() + " :sleep" + t);
                Thread.sleep(t);
                connection.close();
                System.out.println("关闭连接" + Thread.currentThread().getName() + " :sleep" + t);
            }
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