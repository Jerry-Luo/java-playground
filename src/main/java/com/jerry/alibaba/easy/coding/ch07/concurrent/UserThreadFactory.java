package com.jerry.alibaba.easy.coding.ch07.concurrent;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    // 定义线程组名称，在使用 jstack 来排查线程问题时，非常有帮助。
    UserThreadFactory(String whatFeatureOfGroup){
        namePrefix = "UserThreadFactory's " + whatFeatureOfGroup + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0, false);
        System.out.println(thread.getName());
        return thread;
    }


    // 任务执行体
    static class Task implements Runnable{
        private final AtomicLong count = new AtomicLong(0L);

        @Override
        public void run () {
            System.out.println("running_" + count.getAndIncrement());
        }
    }

}
