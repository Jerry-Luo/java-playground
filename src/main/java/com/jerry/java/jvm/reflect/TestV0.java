package com.jerry.java.jvm.reflect;

// v0 版本

import java.lang.reflect.Method;

public class TestV0 {

    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("com.jerry.java.jvm.reflect.TestV0");
        Method method = klass.getMethod("target", int.class);
        method.invoke(null, 0);
    }
}
//java.lang.Exception: #0
//        at javaplayground/com.jerry.java.jvm.reflect.TestV0.target(TestV0.java:9)
//        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
//        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
//        at javaplayground/com.jerry.java.jvm.reflect.TestV0.main(TestV0.java:15)