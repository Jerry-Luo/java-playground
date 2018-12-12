package com.jerry.java.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeSample {

    public int sharedState;

    // 运行结果 Observed data race, former is 13330, latter is 13332
    public void nonSafeAction() {
        while (sharedState < 100000) {
            int former = sharedState++;
            int latter = sharedState;
            if (former != latter - 1) {
                System.out.printf("Observed data race, former is " + former + ", " + "latter is " + latter);
            }
        }
    }

    // 无线程安全问题，程序执行无输出
    // javap -v ThreadSafeSample 输出部分内容如下，利用 monitorenter/monitorexit 对实现了同步的语义：
//    16: monitorenter
//    17: aload_0
//    18: dup
//    19: getfield      #2                  // Field sharedState:I
//    22: dup_x1
//    23: iconst_1
//    24: iadd
//    25: putfield      #2                  // Field sharedState:I
//    28: istore_1
//    29: aload_0
//    30: getfield      #2                  // Field sharedState:I
//    33: istore_2
//    34: aload_3
//    35: monitorexit
    // 代码中使用 synchronized 非常便利，如果用来修饰静态方法，其等同于利用下面代码将方法体囊括进来：
    // synchronized (ClassName.class) {}
    public void safeAction() {
        while (sharedState < 1000000) {

            int former, latter;

            synchronized (this) {
                former = sharedState++;
                latter = sharedState;
            }

            if (former != latter - 1) {
                System.out.printf("Observed data race, former is " + former + ", " + "latter is " + latter);
                return;
            }
        }
    }

    // 这种写法并不安全  运行结果 Observed data race, former is 8812, latter is 8819
    // 可能用法有问题，具体可以参照 JDK 中的 ArrayBlockingQueue 里面的用法
    public void reentrantLock() {
        // 这里是演示创建公平锁，一般情况不需要。
        ReentrantLock fairLock = new ReentrantLock(true);
        fairLock.lock();
        try {
            while (sharedState < 1000000) {
                int former, latter;
                // do something
                former = sharedState++;
                latter = sharedState;
                if (former != latter - 1) {
                    System.out.printf("Observed data race, former is " + former + ", " + "latter is " + latter);
                    return;
                }
            }
        } finally {
            fairLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeSample sample = new ThreadSafeSample();
        Thread threadA = new Thread() {
            public void run() {
//                sample.nonSafeAction();
//                sample.safeAction();
                sample.reentrantLock();
            }
        };
        Thread threadB = new Thread() {
            public void run() {
//                sample.nonSafeAction();
//                sample.safeAction();
                sample.reentrantLock();
            }
        };
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }
}