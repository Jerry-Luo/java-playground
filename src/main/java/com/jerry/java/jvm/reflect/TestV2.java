package com.jerry.java.jvm.reflect;

import java.lang.reflect.Method;

// v2 版本  -Xlog:gc 打印 GC 日志
public class TestV2 {
    public static void target(int i) {
        // 空方法
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("com.jerry.java.jvm.reflect.TestV2");
        Method method = klass.getMethod("target", int.class);

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            method.invoke(null, 128);
        }
    }
}

//  63: aload_2             // 加载 Method 对象
//  64: aconst_null         // 反射调用的第一个参数 null
//  65: iconst_1
//  66: anewarray     #13   // class java/lang/Object  生成一个长度为 1 的 Object 数组
//  69: dup
//  70: iconst_0
//  71: sipush        128
//  74: invokestatic  #14   // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;  将 128 自动装箱成 Integer
//  77: aastore             // 存入 Object 数组
//  78: invokevirtual #15   // Method java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;  反射调用.
