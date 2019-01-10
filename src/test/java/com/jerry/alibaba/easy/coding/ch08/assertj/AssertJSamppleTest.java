package com.jerry.alibaba.easy.coding.ch08.assertj;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

// 使用 AssertJ 的断言
public class AssertJSamppleTest {
    @Test
    public void testUsingAssertJ() {
        // 字符串判断
        String s = "abcde";
        Assertions.assertThat(s)
                .as("字符串判断：判断收尾及长度")
                .startsWith("ab")
                .endsWith("de")
                .hasSize(5);

        // 数字判断
        Integer i = 50;
        Assertions.assertThat(i)
                .as("数字判断：数字大小比较")
                .isGreaterThan(0)
                .isLessThan(100);

        // 日期判断
        Date date1 = new Date();
        Date date2 = new Date(date1.getTime() + 100);
        Date date3 = new Date(date1.getTime() - 100);
        Assertions.assertThat(date1)
                .as("日期判断：日期大小比较")
                .isBefore(date2)
                .isAfter(date3);

        // List 判断
        List<String> list = Arrays.asList("a", "b", "c", "d");
        Assertions.assertThat(list)
                .as("List 的判断：首、尾元素及长度")
                .startsWith("a")
                .endsWith("d")
                .hasSize(4);

        // Map 判断
        Map<String, Object> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        Assertions.assertThat(map)
                .as("Map 的判断：长度及 Key 值")
                .hasSize(3)
                .containsKeys("A", "B", "C");
    }
}
