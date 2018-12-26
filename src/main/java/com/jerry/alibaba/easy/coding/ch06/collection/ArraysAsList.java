package com.jerry.alibaba.easy.coding.ch06.collection;

import java.util.Arrays;
import java.util.List;

public class ArraysAsList {
    public static void main(String[] args) {
        String[] stringArrsy = new String[3];
        stringArrsy[0] = "one";
        stringArrsy[1] = "two";
        stringArrsy[2] = "three";

        List<String> stringList = Arrays.asList(stringArrsy);
        // 修改转换后的集合，成功地把第一个元素"one"改成"oneList"
        stringList.set(0, "oneList");
        System.out.println(stringArrsy[0]);

        // 这是重点，一些三行编译正确，但都会抛出运行时异常
        stringList.add("four");
        stringList.remove(2);
        stringList.clear();
    }
}
