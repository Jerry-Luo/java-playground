package com.jerry.alibaba.easy.coding.ch08.assertj;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

/**
 * 使用 JUnit 的断言
 */
public class JUnitSampleTest {

    @Test
    public void testUsingJunitAssertThat() {
        // 字符串判断
        String s = "abcde";
        Assertions.assertTrue(s.startsWith("ab"));
        Assertions.assertTrue(s.endsWith("de"));
        Assertions.assertEquals(5, s.length());

        // 数字判断
        Integer i = 50;
        Assertions.assertTrue(i > 0);
        Assertions.assertTrue(i < 100 );

        // 日期判断
        Date date1 = new Date();
        Date date2 = new Date(date1.getTime() + 100);
        Date date3 = new Date(date1.getTime() - 100);
        Assertions.assertTrue(date1.before(date2));
        Assertions.assertTrue(date1.after(date3));

        // List 判断
        List<String> list = Arrays.asList("a", "b", "c", "d");
        Assertions.assertEquals("a", list.get(0));
        Assertions.assertEquals(4, list.size());
        Assertions.assertEquals("d", list.get(list.size() - 1));

        // Map 判断
        Map<String, Object> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        Set<String> set = map.keySet();
        Assertions.assertEquals(3, map.size());
        Assertions.assertTrue(set.containsAll(Arrays.asList("A", "B", "C")));
    }
}
