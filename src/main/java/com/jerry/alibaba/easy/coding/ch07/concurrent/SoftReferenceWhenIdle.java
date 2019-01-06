package com.jerry.alibaba.easy.coding.ch07.concurrent;

import java.lang.ref.SoftReference;

/**
 * 验证一下，如果内存没有达到 OOM, 软引用持有的对象会被回收吗？
 */
public class SoftReferenceWhenIdle {
    public static void main(String[] args) {
        House seller = new House();

        SoftReference<House> buyer2 = new SoftReference<>(seller);
        seller = null;

        while (true) {
            // 下方两句代码建议 JVM 进行垃圾回收
            // System.gc() 方法建议垃圾收集器尽快进行垃圾收集，具体何时执行仍由 JVM 来判断。
            System.gc();
            // System.runFinalization() 方法的作用是强制调用已经失去引用对象的 finalize()。
            System.runFinalization();
            // 在代码中同时调用上面两句，有利于更快地执行垃圾回收。

            if (buyer2.get() == null) {
                System.out.println("house is null.");
                break;
            }else{
                System.out.println("still there.");
            }
        }

    }
}
