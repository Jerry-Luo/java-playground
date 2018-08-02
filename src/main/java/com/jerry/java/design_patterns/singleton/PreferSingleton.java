package com.jerry.java.design_patterns.singleton;

/**
 * 只有当调用 PreferSingleton.getInstance 时，程序才会访问 LazyHolder.INSTANCE，才会触发对 LazyHolder 的初始化（对应第 4 种情况），继而新建一个 Singleton 的实例。
 * 由于类初始化是线程安全的，并且仅被执行一次，因此程序可以确保多线程环境下有且仅有一个 Singleton 实例。
 */
public class PreferSingleton {

    private PreferSingleton() {}

    private static class LazyHolder {
        static final PreferSingleton INSTANCE = new PreferSingleton();
    }

    public static PreferSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}
