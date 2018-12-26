package com.jerry.alibaba.easy.coding.ch04.classloader;

import java.net.URL;

public class JarLoadByBootstrapClassloader {
    // 查看 Bootstrap 所有已经加载的类库
    public static void main(String[] args) {
        URL[] urls = null; // null;sun.misc.Launcher.getBoostrapClassPath().getURLs();
        for (java.net.URL url : urls) {
            System.out.println(url.toExternalForm());
        }
    }
}
// -Xbootclasspath/a:/Users/jerry/book/easycoding/byjdk11/src
