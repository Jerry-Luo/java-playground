package com.jerry.alibaba.easy.coding.ch04.classloader;

import java.io.*;

public class CustomClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClassFromCustomPath(name);
            if (result == null) {
                throw new FileNotFoundException();
            } else {
                return defineClass(name, result, 0, result.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException(name);
    }

    private byte[] getClassFromCustomPath(String name) throws IOException {
        // 从自定义路径加载指定类
        File f = new File("/Users/Jerry/Preference/myworkspace/java-playground/target/classes/com/jerry/alibaba/easy/coding/ch04/classloader/TestWhoLoad.class");
        FileInputStream in = new FileInputStream(f);
        return in.readAllBytes();
    }

    public static void main(String[] args) {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        try {
            Class<?> clazz = Class.forName("TestWhoLoad", true, customClassLoader);
            Object obj = clazz.newInstance();
            System.out.println(obj.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
