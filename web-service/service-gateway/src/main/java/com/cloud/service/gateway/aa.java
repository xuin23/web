package com.cloud.service.gateway;

public class aa {
    public static void main(String[] args) throws InterruptedException {
        var ref = new Object() {
            int a = 0;
        };
        new Thread(() -> {
            while (true) {
                synchronized (ref) {
                    if (ref.a > 0) {
                        System.out.println(ref.a);
                        ref.a = 0;
                    }
                }
            }
        }).start();
        while (true) {
            synchronized (ref) {
                Thread.sleep(999);
                ref.a = (int) (Math.random() * 10);
            }
            Thread.sleep(1);
        }
    }
}
