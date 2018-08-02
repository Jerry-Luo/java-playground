package com.jerry.java.design_patterns.singleton;

// 双检锁方式实现的单利模式
public class Singleton1 {

    // 这里的 volatile 能够提供可见性，以及保证 getInstance 返回的是初始化完全的对象。
    private static volatile Singleton1 singleton1 = null;

    private Singleton1 () {}

    public static Singleton1 getSingleton1() {
        if (singleton1 == null) { // 在同步前进行 null 检查，以尽量避免进入相对昂贵的同步块。尽量避免重复进入同步块。
            synchronized (Singleton1.class) { // 直接在 class 级别进行同步，保证线程安全的类方法调用。同步 .class, 意味着对同步类方法调用。
                if (singleton1 == null) {
                    singleton1 = new Singleton1();
                }
            }
        }

        return singleton1;
    }
}
