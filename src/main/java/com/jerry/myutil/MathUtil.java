package com.jerry.myutil;

import java.math.BigInteger;

/**
 * 数学相关工具类
 */
public class MathUtil {

    /**
     * 十进制转换成二进制
     * @param decimalSource 十进制数值
     * @return 二进制字符串
     */
    public static String decimalToBinary(int decimalSource) {
        // 转换成 BigInteger 类型，默认是十进制
        BigInteger bi = new BigInteger(String.valueOf(decimalSource));
        // 参数 2 指定的是转换成二进制
        return bi.toString(2);
    }

    /**
     * 二进制转换成十进制
     * @param binarySource 二进制字符串
     * @return 十进制数值
     */
    public static int binaryToDecimal(String binarySource) {
        // 转换为 BigInteger 类型，参数 2 指定的是二进制
        BigInteger bi = new BigInteger(binarySource, 2);
        // 默认转换为十进制
        return Integer.parseInt(bi.toString());
    }

    /**
     * 向左移位
     * @param num- 等待移位的十进制数, m- 向左移的位数
     * @return int- 移位后的十进制数
     */
    public static int leftShift(int num, int m) {
        return num << m;
    }

    /**
     * 向右移位
     * @param num- 等待移位的十进制数, m- 向右移的位数
     * @return int- 移位后的十进制数
     */
    public static int rightShift(int num, int m) {
        return num >>> m;
    }

    /**
     * 二进制按位“或”的操作
     * @param num1- 第一个数字，num2- 第二个数字
     * @return 二进制按位“或”的结果
     */
    public static int or(int num1, int num2) {

        return (num1 | num2);

    }

    /**
     * 二进制按位“与”的操作
     * @param num1- 第一个数字，num2- 第二个数字
     * @return 二进制按位“与”的结果
     */
    public static int and(int num1, int num2) {

        return (num1 & num2);

    }

    /**
     * 二进制按位“异或”的操作
     * @param num1- 第一个数字，num2- 第二个数字
     * @return 二进制按位“异或”的结果
     */
    public static int xor(int num1, int num2) {

        return (num1 ^ num2);

    }
}
