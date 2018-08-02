package com.jerry.java.jvm.bridgemethod;

public class Test {
    public static void main(String[] args) {

        MyNode mn = new MyNode(5);
        Node n = mn;            // A raw type - compiler throws an unchecked warning
        n.setData("Hello");     // Causes a ClassCastException to be thrown.
        Integer x = mn.data;


        //After type erasure, this code becomes:
//        MyNode mn = new MyNode(5);
//        Node n = (MyNode)mn;         // A raw type - compiler throws an unchecked warning
//        n.setData("Hello");
//        Integer x = (String)mn.data; // Causes a ClassCastException to be thrown.

    }
}
