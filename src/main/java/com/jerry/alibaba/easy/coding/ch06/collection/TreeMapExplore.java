package com.jerry.alibaba.easy.coding.ch06.collection;

import java.util.TreeMap;

public class TreeMapExplore {

    public static void main(String[] args) {

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(55, "fifty-five");
        treeMap.put(56, "fifty-six");
        treeMap.put(57, "fifty-seven");
        treeMap.put(58, "fifty-eight");
        treeMap.put(83, "eighty-three");
        treeMap.remove(57);
        treeMap.put(59, "fifty-nine");

        // 为什么在 58 和 59 之间插入 83 和删除 57 呢? 是因为需要构造这样的场景: 旋转两次(先右旋 ，再左旋)。
    }
}
