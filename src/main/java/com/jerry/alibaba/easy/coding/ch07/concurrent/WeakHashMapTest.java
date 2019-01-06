package com.jerry.alibaba.easy.coding.ch07.concurrent;

import java.util.WeakHashMap;

/**
 * WeakReference 典型的应用
 */
public class WeakHashMapTest {
    public static void main(String[] args) {
        House seller1 = new House("1 号卖家房源");
        SellerInfo sellerInfo1 = new SellerInfo();

        House seller2 = new House("2 号卖家房源");
        SellerInfo sellerInfo2 = new SellerInfo();

        // 如果换成 HashMap, 则 key 是对 House 对象的强引用
        WeakHashMap<House, SellerInfo> weakHashMap = new WeakHashMap<>();

        weakHashMap.put(seller1, sellerInfo1);
        weakHashMap.put(seller2, sellerInfo2);

        System.out.println("WeakHashMap before null, size = " + weakHashMap.size());

        seller1 = null;

        System.gc();
        System.runFinalization();

        // 如果换成 HashMap, size 依然等于 2
        System.out.println("weakHashMap after null, size = " + weakHashMap.size());
        System.out.println(weakHashMap);
    }
}

class SellerInfo{}
