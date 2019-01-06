package com.jerry.alibaba.easy.coding.ch07.concurrent;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20m -Xmx20m
 */
public class SoftReferenceHouse {
    public static void main(String[] args) {
//         List<House> houses = new ArrayList<House>();
        List<SoftReference> houses = new ArrayList<>();

        // 剧情反转注释处
        int i = 0;
        while (true) {
//             houses.add(new House());

//          剧情反转注释处
            SoftReference<House> buyer2 = new SoftReference<>(new House());
//          剧情反转注释处
            houses.add(buyer2);

            System.out.println("i=" + (++i));
        }
    }
}

class House {
    private static final Integer DOOR_NUMBER = 2000;
    public Door[] doors = new Door[DOOR_NUMBER];
    class Door {}

    private String sellerName;
    public House(String sellerName) {
        this.sellerName = sellerName;
    }

    public House() {}

    @Override
    public String toString() {
        return sellerName;
    }
}

// 如果不使用 软引用 当运行到 i=2278 的时候即发生 OOM
// 如果使用 软引用 则能运行到 i=360145 的时候才发生 OOM
// 在即将 OOM 之前，垃圾回收器会把这些软引用指向的对象加入回收范围，以获得更多的内存空间，让程序能够继续健康运行。