package com.jerry.math;

import com.jerry.myutil.MathUtil;

public class Lesson1_1 {

    public static void main(String[] args) {

        int a = 53;
        String b = "110101";

        // 获取十进制数 53 的二进制数
        System.out.println(String.format(" 数字 %d 的二进制是 %s", a, MathUtil.decimalToBinary(a)));

        // 获取二进制数 110101 的十进制数
        System.out.println(String.format(" 数字 %s 的十进制是 %d", b, MathUtil.binaryToDecimal(b)));
    }

}
