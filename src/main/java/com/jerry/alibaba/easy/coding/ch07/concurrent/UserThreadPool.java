package com.jerry.alibaba.easy.coding.ch07.concurrent;

import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UserThreadPool {
    public static void main(String[] args) {
        // 缓存队列设置固定长度为 2， 为了快速触发 rejectHandler
        BlockingQueue queue = new LinkedBlockingQueue(2);

        // 假设外部任务线程的来源由机房 1 和 机房 2 的混合调用
        UserThreadFactory f1 = new UserThreadFactory("第一机房");
        UserThreadFactory f2 = new UserThreadFactory("第二机房");

        UserRejectHandler handler = new UserRejectHandler();

        // 核心线程为 1， 最大线程为 2， 为了保证触发 rejectHandler
        ThreadPoolExecutor threadPoolFirst = new ThreadPoolExecutor(1, 2, 60,
                TimeUnit.SECONDS, queue, f1, handler);

        // 利用第二个线程工厂实例创建第二个线程池
        ThreadPoolExecutor threadPoolSecond = new ThreadPoolExecutor(1, 2, 60,
                TimeUnit.SECONDS, queue, f2, handler);

        // 创建 400 个任务线程
        Runnable task = new UserThreadFactory.Task();
        for (int i = 0; i < 200; i++) {
            threadPoolFirst.execute(task);
            threadPoolSecond.execute(task);
        }
    }
}
