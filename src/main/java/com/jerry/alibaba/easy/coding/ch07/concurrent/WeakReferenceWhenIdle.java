package com.jerry.alibaba.easy.coding.ch07.concurrent;

import java.lang.ref.WeakReference;

/**
 * JVM 启动参数加 -XX:+PrintGCDetails (或高版本 JDK 使用 -Xlog:gc)
 */
public class WeakReferenceWhenIdle {
    public static void main(String[] args) {
        House seller = new House();
        WeakReference<House> buyer3 = new WeakReference<>(seller);
        seller = null;

        long start = System.nanoTime();
        int count = 0;
        while (true) {
            if (buyer3.get() == null) {
                long duration = (System.nanoTime() - start) / (1000 * 1000);
                System.out.println("House is null and exited time = " + duration + "ms");
                break;
            } else {
                System.out.println("still there. count = " + (count++));
            }
        }
    }
}
