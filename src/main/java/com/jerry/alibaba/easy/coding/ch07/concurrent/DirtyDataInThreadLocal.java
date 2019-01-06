package com.jerry.alibaba.easy.coding.ch07.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DirtyDataInThreadLocal {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        // 使用固定大小为 1 的线程池，说明上一个的线程属性会被下一个线程属性复用
        ExecutorService pool = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 2; i++) {
            Mythread thread = new Mythread();
            pool.execute(thread);
        }
    }

    private static class Mythread extends Thread {
        private static boolean flag = true;

        @Override
        public void run () {
            if (flag) {
                // 第一个线程 set 后， 并没有进行 remove
                // 而第二个线程由于某种原因没有进行 set 操作
                threadLocal.set(this.getName() + ". session info.");
                flag = false;
            }
            System.out.println(this.getName() + " 线程是 " + threadLocal.get());
        }
    }
}
