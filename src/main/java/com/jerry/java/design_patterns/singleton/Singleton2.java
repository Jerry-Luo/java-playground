package com.jerry.java.design_patterns.singleton;

// 利用内部类持有静态对象的方式实现单例，其理论依据是对象初始化过程中隐含的初始化锁，
// 这种和 Signleton1 用双检锁的实现都能保证线程安全，不过语法稍显晦涩，未必有特别的优势。
public class Singleton2 {

    private Singleton2() {
    }

    public static Singleton2 getSingleton2() {
        return Holder.singleton2;
    }

    private static class Holder {
        private static Singleton2 singleton2 = new Singleton2();
    }
}
