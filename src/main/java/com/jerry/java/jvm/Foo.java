package com.jerry.java.jvm;

public class Foo {
    static boolean boolValue;

    public static void main(String[] args) {
        boolValue = true;

        if (boolValue) System.out.println("Hello, Java");
        if (boolValue == true) System.out.println("Hello JVM");
    }
}

