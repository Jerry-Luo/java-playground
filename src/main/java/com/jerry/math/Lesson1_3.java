package com.jerry.math;

import com.jerry.myutil.MathUtil;

public class Lesson1_3 {

    public static void main(String[] args) {

        int a = 53;
        int b = 35;

        // 获取十进制数 53 和 35 的按位“或”
        System.out.println(String.format(" 数字 %d(%s) 和数字 %d(%s) 的按位‘或’结果是 %d(%s)", a, MathUtil.decimalToBinary(a), b, MathUtil.decimalToBinary(b), MathUtil.or(a, b),
            MathUtil.decimalToBinary(MathUtil.or(a, b))));

        // 获取十进制数 53 和 35 的按位“与”
        System.out.println(String.format(" 数字 %d(%s) 和数字 %d(%s) 的按位‘与’结果是 %d(%s)", a, MathUtil.decimalToBinary(a), b, MathUtil.decimalToBinary(b), MathUtil.and(a, b),
            MathUtil.decimalToBinary(MathUtil.and(a, b))));

        // 获取十进制数 53 和 35 的按位“异或”
        System.out.println(String.format(" 数字 %d(%s) 和数字 %d(%s) 的按位‘异或’结果是 %d(%s)", a, MathUtil.decimalToBinary(a), a, MathUtil.decimalToBinary(a), MathUtil.xor(a, a),
            MathUtil.decimalToBinary(MathUtil.xor(a, a))));

    }

}
