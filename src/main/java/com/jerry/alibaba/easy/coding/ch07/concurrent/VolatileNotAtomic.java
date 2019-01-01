package com.jerry.alibaba.easy.coding.ch07.concurrent;

public class VolatileNotAtomic {
    private static volatile long count = 0L;
    private static final int NUMBER = 10000;

    public static void main(String[] args) {
        Thread subtractThread = new SubtractThread();
        subtractThread.start();

        for (int i = 0; i < NUMBER; i++) {
//            synchronized(VolatileNotAtomic.class) {
                VolatileNotAtomic.count++;
//            }
        }

        // 等待减法线程结束
        while (subtractThread.isAlive()){}

        System.out.println("count 最后的值为：" + count);
    }

    private static class SubtractThread extends Thread {

        @Override
        public void run (){
            for (int i = 0; i < NUMBER; i++) {
//                synchronized(VolatileNotAtomic.class) {
                    VolatileNotAtomic.count--;
//                }
            }
        }
    }
}

// 多次执行后，发现结果基本都不为 0。如果在 count++ 和 count-- 两处都进行加锁操作，才会得到预期是 0 的结果。
