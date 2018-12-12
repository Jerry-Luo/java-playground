package com.jerry.java.concurrency.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable task = () -> System.out.println("Hello World!!");
        Future future = Executors.newFixedThreadPool(1).submit(task);
        Object result = future.get();
        System.out.println(result);


        // 先来看看守护线程（Daemon Thread），有的时候应用中需要一个长期驻留的服务程序，
        // 但是不希望其影响应用退出，就可以将其设置为守护线程，
        // 如果 JVM 发现只有守护线程存在时，将结束进程，具体可以参考下面代码段。
        // 注意，必须在线程启动之前设置。
        Thread daemonThread = new Thread();
        daemonThread.setDaemon(true);
        daemonThread.start();


    }
}
