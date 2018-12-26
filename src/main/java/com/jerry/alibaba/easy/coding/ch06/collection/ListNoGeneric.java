package com.jerry.alibaba.easy.coding.ch06.collection;

import java.util.ArrayList;
import java.util.List;

public class ListNoGeneric {
    public static void main(String[] args) {
        // 第一段：泛型出现之前的集合定义方式
        List a1 = new ArrayList();
        a1.add(new Object());
        a1.add(Integer.valueOf("111"));
        a1.add(new String("hello a1a1"));

        // 第二段：把 a1 引用赋值给 a2，注意 a2 与 a1 的区别是增加了范型限制 <Object>
        List<Object> a2 = a1;
        a2.add(new Object());
        a2.add(Integer.valueOf("222"));
        a2.add(new String("hello a2a2"));

        // 第三段：把 a1 引用赋值给 a3， 注意 a3 与 a1 的区别是增加了范型 <Integer>
        List<Integer> a3 = a1;
        a3.add(new Integer(333));
        // 下方两行编译出错，不允许增加非 Integer 类型进入集合
//        a3.add(new Object());
//        a3.add(new String("hello a3a3"));

        // 第四段： 把 a1 引用赋值给 a4， a1 与 a4 的区别是增加了通配符
        List<?> a4 = a1;
        // 允许删除和清除元素
        a4.remove(0);
        a4.clear();
        // 编译出错。不允许增加任何元素
//        a4.add(new Object());
    }
}