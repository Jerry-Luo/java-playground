package com.jerry.alibaba.easy.coding.ch08.unittest;

public class CoverageSampleMethods {
    public Boolean testMethod(int a, int b, int c) {
        boolean result = false;
        if (a == 1 && b == 2 || c == 3) {
            result = true;
        }
        return result;
    }
}
