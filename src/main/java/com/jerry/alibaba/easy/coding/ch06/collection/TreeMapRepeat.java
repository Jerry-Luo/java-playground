package com.jerry.alibaba.easy.coding.ch06.collection;

import java.util.TreeMap;
// 不同于 HashMap, TreeMap并非定要覆写 hashCode和 equals方法来达到 Key去重的目的
public class TreeMapRepeat {
    public static void main(String[] args) {
        TreeMap map = new TreeMap();
        map.put(new Key(), "value one");
        map.put(new Key(), "value two");

        // TreeMap, size=2, 因为key的去重规则是根据排序结果
        System.out.println(map.size());
    }
}
// 上述示例把红色的 TreeMap 换成 HashMap, size 的结果则从 2 变为 l。
// 注意 HashMap 是 使用 hashCode 和 equals 实现去重的。
// 而 TreeMap 依靠 Comparable 或 Comparator 来实现 Key 的去重。

class Key implements Comparable<Key> {

    @Override
    // 返回负的常数，表示此对象永远小于输入的other对象，此处决定treemap的size = 2
    public int compareTo(Key o) {
        return -1;
    }

    @Override
    // hash 是相等的
    public int hashCode () {
        return 1;
    }

    @Override
    // equals 比较也是相等的
    public boolean equals(Object obj) {
        return true;
    }
}
