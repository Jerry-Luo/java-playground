package com.jerry.tmp;

import com.jerry.myutil.MathUtil;

public class Test {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int COUNT_MASK = (1 << COUNT_BITS) - 1;

    public static void main(String[] args) {
        System.out.println(COUNT_BITS);

        System.out.println(MathUtil.decimalToBinary(COUNT_MASK));
    }
}
