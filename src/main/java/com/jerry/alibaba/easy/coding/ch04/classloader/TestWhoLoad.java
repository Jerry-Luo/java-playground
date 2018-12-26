package com.jerry.alibaba.easy.coding.ch04.classloader;

import java.util.HashMap;
import java.util.Map;

public class TestWhoLoad {

    public static void main(String[] args) {
        // 正在使用的类加载器：jdk.internal.loader.ClassLoaders$AppClassLoader
        ClassLoader c = TestWhoLoad.class.getClassLoader();
        // AppClassLoader 的父加载器是 jdk.internal.loader.ClassLoaders$PlatformClassLoader
        ClassLoader c1 = c.getParent();
        // ClassLoaders$PlatformClassLoader 的父类加载器是 Bootstrap。它是使用 C++ 来实现的，返回 null
        ClassLoader c2 = c1.getParent();

        // 代码上方的注内容为 JDK11 的执行结果。

        // 在 JDK8 环境中执行结果如下
        // sun.misc.Launcher\$AppClassLoader
        // sun.misc.Launcher\$ExtClassLoader
        // null
        Map map = new HashMap();
    }
}
