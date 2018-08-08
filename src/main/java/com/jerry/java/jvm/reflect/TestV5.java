package com.jerry.java.jvm.reflect;

import java.lang.reflect.Method;


// v5 版本
public class TestV5 {
    public static void target(int i) {
        // 空方法
    }

    public static void main(String[] args) throws Exception {
//        Class<?> klass = Class.forName("com.jerry.java.jvm.reflect.TestV5");
//        Method method = klass.getMethod("target", int.class);
//        method.setAccessible(true);  // 关闭权限检查
//        polluteProfile();
//
//        long current = System.currentTimeMillis();
//        for (int i = 1; i <= 2_000_000_000; i++) {
//            if (i % 100_000_000 == 0) {
//                long temp = System.currentTimeMillis();
//                System.out.println(temp - current);
//                current = temp;
//            }
//
//            method.invoke(null, 128);
//        }

        Method method1 = TestV5.class.getMethod("target", int.class);
        Method method2 = TestV5.class.getMethod("target", int.class);
        System.out.println("method1 == method2 ? " + (method1 == method2));
        System.out.println("method1 equals method2 ? " + (method1.equals(method2)));
    }

    public static void polluteProfile() throws Exception {
        Method method1 = TestV5.class.getMethod("target1", int.class);
        Method method2 = TestV5.class.getMethod("target2", int.class);
        for (int i = 0; i < 2000; i++) {
            method1.invoke(null, 0);
            method2.invoke(null, 0);
        }
    }
    public static void target1(int i) { }
    public static void target2(int i) { }
}

//除此之外，我们还可以提高 Java 虚拟机关于每个调用能够记录的类型数目（对应虚拟机参数 -XX:TypeProfileWidth，默认值为 2，这里设置为 3）。
// 最终测得的结果约为基准的 2.8 倍，尽管它和原本的 1.3 倍还有一定的差距，但总算是比 6.7 倍好多了。

