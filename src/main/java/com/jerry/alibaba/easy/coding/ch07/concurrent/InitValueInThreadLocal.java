package com.jerry.alibaba.easy.coding.ch07.concurrent;

import java.util.concurrent.TimeUnit;

public class InitValueInThreadLocal {
    private static final StringBuilder INIT_VALUE = new StringBuilder("init");
    // 覆写 ThreadLocal 的 initialValue, 返回 StringBuilder 静态引用
    private static final ThreadLocal<StringBuilder> builder = new ThreadLocal<>(){
        protected StringBuilder initialValue() {
            return INIT_VALUE;
        }
    };

    private static class AppendStringThread extends Thread {
        @Override
        public void run() {
            StringBuilder inThread = builder.get();
            for (int i = 0; i < 10; i++){
                inThread.append("-" + i);
            }
            System.out.println(inThread.toString());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new AppendStringThread().start();
        }
        TimeUnit.SECONDS.sleep(10);
    }
}
