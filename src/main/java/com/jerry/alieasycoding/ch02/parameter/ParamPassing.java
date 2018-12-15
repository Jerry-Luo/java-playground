package com.jerry.alieasycoding.ch02.parameter;

import java.util.*;

public class ParamPassing {

    private static int intStatic = 222;
    private static String stringStatic = "Old String";
    private static StringBuilder stringBuilderStatic = new StringBuilder("Old stringBuilder");

    public static void main(String[] args) {

//        // 实参调用
//        method(intStatic);
//        method(stringStatic);
//        method(stringBuilderStatic, stringBuilderStatic);
//
//        // 输出依然是 222 (第一处)
//        System.out.println(intStatic);
//        method();
//        // 无参方法调用之后，反而修改为 888 (第2处)
//        System.out.println(intStatic);
//        // 输出依然是 Old String
//        System.out.println(stringStatic);
//        // 输出结果参考下方分析
//        System.out.println(stringBuilderStatic);
        List<String> list = new ArrayList<>();
        for(int i=0;i < 1000000; i++){
            list.add(String.valueOf(UUID.randomUUID().toString().hashCode()));
        }
        Set<String> set = new HashSet<>(list);
        System.out.println(list.size());
        System.out.println(set.size());
    }

    // A 方法
    public static void method(int intStatic) {
        intStatic = 777;
    }

    // B 方法
    public static void method () {
        intStatic = 888;
    }

    // C 方法
    public static void method(String stringStatic) {
        // String 是 immutable 对象， String 没有提供任何方法用于修改对象
        stringStatic = "new string";
    }

    // D 方法
    public static void method(StringBuilder stringBuilderStatic1, StringBuilder stringBuilderStatic2) {
        // 直接使用参数引用修改对象 （第3处）
        stringBuilderStatic1.append(".method.first-");
        stringBuilderStatic2.append("method.second-");

        // 引用重新赋值
        stringBuilderStatic1 = new StringBuilder("new stringBuilder");
        stringBuilderStatic1.append("new method's append");
    }
}