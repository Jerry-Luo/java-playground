package com.jerry.java.jvm.methodhandle;

import java.lang.invoke.*;

public class Foo {

    public static void bar(Object o) {
        new Exception().printStackTrace();
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodType t = MethodType.methodType(void.class, Object.class);
        MethodHandle mh = l.findStatic(Foo.class, "bar", t);
        mh.invokeExact(new Object());
    }
}

// 直接运行输出栈信息，部分栈信息被 jvm 隐藏了
//java.lang.Exception
//	at javaplayground/com.jerry.java.jvm.methodhandle.Foo.bar(Foo.java:8)
//	at javaplayground/com.jerry.java.jvm.methodhandle.Foo.main(Foo.java:15)

// 开启 -XX:+UnlockDiagnosticVMOptions -XX:+ShowHiddenFrames 后输出栈信息：

//java.lang.Exception
//	at javaplayground/com.jerry.java.jvm.methodhandle.Foo.bar(Foo.java:8)
//	at java.base/java.lang.invoke.DirectMethodHandle$Holder.invokeStatic(DirectMethodHandle$Holder:1000010)
//	at java.base/java.lang.invoke.LambdaForm$MH/280744458.invokeExact_MT(LambdaForm$MH:1000019)
//	at javaplayground/com.jerry.java.jvm.methodhandle.Foo.main(Foo.java:15)

//实际上，Java 虚拟机会对 invokeExact 调用做特殊处理，调用至一个共享的、与方法句柄类型相关的特殊适配器中。
//这个适配器是一个 LambdaForm，我们可以通过添加虚拟机参数将之导出成 class 文件
// （-Djava.lang.invoke.MethodHandle.DUMP_CLASS_FILES=true）。
