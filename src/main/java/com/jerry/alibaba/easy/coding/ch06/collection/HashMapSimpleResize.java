package com.jerry.alibaba.easy.coding.ch06.collection;

import javax.security.auth.callback.TextOutputCallback;
import java.util.HashMap;

/**
 * jdk1.7下
 * 构造一个hashmap集合，把所有元素放置在同一个hash桶中，
 * 达到扩容条件后，观察一下resize方法是如何进行数据迁移的。
 */
public class HashMapSimpleResize {
    private static HashMap map = new HashMap();

    public static void main(String[] args) {

        // 扩容的阈值是 table.length * 0.75
        // 第一次扩容发生在第13个元素置入时
//        for (int i = 0; i < 13; i++) {
//            map.put(new UserKey(), new EasyCoding());
//        }
    }
}

class UserKey {

    // 目的是让所有的 Entry 都在同一个 Hash 桶内
    public int hashCode(){
        return 1;
    }

    // 保证 e.hash == hash && ((k = e.key) == key || key.equals(k)) 为 false
    // 如果为 true, 则会对同一个 key 上的值进行覆盖，不会形成链表。
    public boolean equals(Object object) {
        return false;
    }
}

class EasyCoding{}
