package com.jerry.math;

import com.jerry.myutil.MathUtil;

public class Lesson1_2 {

    public static void main(String[] args) {

        int num = 53;
        int m = 1;
        testShift(num, m);

        System.out.println();

        m = 3;
        testShift(num, m);

    }

    public static void testShift(int num, int m) {
        // 测试向左移位
        System.out.println(String.format(" 数字 %d 的二进制向左移 %d 位是 %d", num, m, MathUtil.leftShift(num, m)));
        // 测试向右移位
        System.out.println(String.format(" 数字 %d 的二进制向右移 %d 位是 %d", num, m, MathUtil.rightShift(num, m)));

    }

}
