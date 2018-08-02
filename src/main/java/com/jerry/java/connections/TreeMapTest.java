package com.jerry.java.connections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key5", "value5");
        map.put("key4", "value4");
        map.put("key3", "value3");


        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }

        System.out.println("---------------------");

        Map<String, String> treeMap = new TreeMap<>(map);
        for (String key : treeMap.keySet()) {
            System.out.println(key + " : " + treeMap.get(key));
        }
    }
}
