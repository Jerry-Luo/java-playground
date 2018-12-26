package com.jerry.alibaba.easy.coding.ch06.collection;

import java.util.ArrayList;
import java.util.List;

public class ToArraySpeedTest {
    private static final int COUNT = 100 * 100 * 100;

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>(COUNT);

        //构造一个 100 万个元素的测试集合
        for (int i = 0; i < COUNT; i++) {
            list.add(i * 1.0);
        }

        long start = System.nanoTime();
        Double[] notEnoughArray = new Double[COUNT - 1];
        list.toArray(notEnoughArray);
        long middle1 = System.nanoTime();

        Double[] equealArray = new Double[COUNT];
        list.toArray(equealArray);
        long middle2 = System.nanoTime();

        Double[] doubleArray = new Double[COUNT * 2];
        list.toArray(doubleArray);
        long end = System.nanoTime();

        long notEnoughArrayTime = middle1 - start;
        long equalArrayTime = middle2 - middle1;
        long doubleArrayTime = end - middle2;

        System.out.println("notEnoughArrayTime: " + notEnoughArrayTime);
        System.out.println("equalArrayTime: " + equalArrayTime);
        System.out.println("doubleArrayTime: " + doubleArrayTime);
    }
}
