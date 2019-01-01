package com.jerry.alibaba.easy.coding.ch06.collection;

import java.util.HashMap;

/**
 * 演示 HashMap 死链
 */
public class HashMapEndlessLoop {
    private static HashMap<Long, EasyCoding> map = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++){
            (new Thread(){
                public void run() {
                    map.put(System.nanoTime(), new EasyCoding());
                }
            }).start();
        }
    }
}
