package com.jerry.java.jvm.reflect;

import java.lang.reflect.Method;

public class TestV1 {

    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("com.jerry.java.jvm.reflect.TestV1");
        Method method = klass.getMethod("target", int.class);
        for (int i = 0; i < 20; i++) {
            method.invoke(null, i);
        }
    }
}

//动态实现和本地实现相比，其运行效率要快上 20 倍。这是因为动态实现无需经过 Java 到 C++ 再到 Java 的切换，
//但由于生成字节码十分耗时，仅调用一次的话，反而是本地实现要快上 3 到 4 倍。

//考虑到许多反射调用仅会执行一次，Java 虚拟机设置了一个阈值 15（可以通过 -Dsun.reflect.inflationThreshold= 来调整），
//当某个反射调用的调用次数在 15 之下时，采用本地实现；当达到 15 时，便开始动态生成字节码，并将委派实现的委派对象切换至动态实现，
//这个过程我们称之为 Inflation。

//反射调用的 Inflation 机制是可以通过参数（-Dsun.reflect.noInflation=true）来关闭的。
//这样一来，在反射调用一开始便会直接生成动态实现，而不会使用委派实现或者本地实现。

//# 使用 -verbose:class 打印加载的类
//$ java -verbose:class Test

// 从第 16 个开始 调用 GeneratedMethodAccessor1.invoke
// 16 个之前调用 NativeMethodAccessorImpl.invoke

//java.lang.Exception: #14
//	at javaplayground/com.jerry.java.jvm.reflect.TestV1.target(TestV1.java:8)
//	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
//	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
//	at javaplayground/com.jerry.java.jvm.reflect.TestV1.main(TestV1.java:15)
//[0.524s][info][class,load] jdk.internal.reflect.ClassFileConstants source: jrt:/java.base
//[0.525s][info][class,load] jdk.internal.reflect.AccessorGenerator source: jrt:/java.base
//[0.525s][info][class,load] jdk.internal.reflect.MethodAccessorGenerator source: jrt:/java.base
//[0.527s][info][class,load] jdk.internal.reflect.ByteVectorFactory source: jrt:/java.base
//[0.528s][info][class,load] jdk.internal.reflect.ByteVector source: jrt:/java.base
//[0.528s][info][class,load] jdk.internal.reflect.ByteVectorImpl source: jrt:/java.base
//[0.529s][info][class,load] jdk.internal.reflect.ClassFileAssembler source: jrt:/java.base
//[0.529s][info][class,load] jdk.internal.reflect.UTF8 source: jrt:/java.base
//[0.530s][info][class,load] jdk.internal.reflect.Label source: jrt:/java.base
//[0.530s][info][class,load] jdk.internal.reflect.Label$PatchInfo source: jrt:/java.base
//[0.531s][info][class,load] jdk.internal.reflect.MethodAccessorGenerator$1 source: jrt:/java.base
//[0.531s][info][class,load] jdk.internal.reflect.ClassDefiner source: jrt:/java.base
//[0.531s][info][class,load] jdk.internal.reflect.ClassDefiner$1 source: jrt:/java.base
//[0.531s][info][class,load] jdk.internal.reflect.GeneratedMethodAccessor1 source: __JVM_DefineClass__
//[0.533s][info][class,load] java.lang.Shutdown source: jrt:/java.base
//[0.533s][info][class,load] java.lang.Shutdown$Lock source: jrt:/java.base
//java.lang.Exception: #15
//	at javaplayground/com.jerry.java.jvm.reflect.TestV1.target(TestV1.java:8)
//	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
//	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
//	at javaplayground/com.jerry.java.jvm.reflect.TestV1.main(TestV1.java:15)
//java.lang.Exception: #16
//	at javaplayground/com.jerry.java.jvm.reflect.TestV1.target(TestV1.java:8)
//	at jdk.internal.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
//	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
//	at javaplayground/com.jerry.java.jvm.reflect.TestV1.main(TestV1.java:15)