package com.jerry.java.concurrency.utils;

import java.util.concurrent.Semaphore;

/**
 * 注意，这段代码，更侧重的是演示 Semaphore 的功能以及局限性，
 * 其实有很多线程编程中的反实践，比如使用了 sleep 来协调任务执行，
 * 而且使用轮询调用 availalePermits 来检测信号量获取情况，
 * 这都是很低效并且脆弱的，通常只是用在测试或者诊断场景。
 */
public class AbnormalSemaphoreSample {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new MyWorker(semaphore));
            t.start();
        }

        System.out.println("Action...GO!");
        semaphore.release(5);

        System.out.println("Wait for permits off");
        while (semaphore.availablePermits() != 0) {
            Thread.sleep(100L);
        }

        System.out.println("Action...GO again!");
        semaphore.release(5);
    }
}

class MyWorker implements Runnable {

    private Semaphore semaphore;

    public MyWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Executed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
