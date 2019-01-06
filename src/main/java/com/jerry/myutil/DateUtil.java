package com.jerry.myutil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtil {
    /**
     * SimpleDateFormat 是线程不安全的类，定义为 static 对象，会有数据同步风险。
     * 通过源码可以看出， SimpleDateFonnat 内部有一个 Calendar对象，在日期转字符串或字符串转曰期的过程中，
     * 多线程共享时有非常高的概率产生错误 ， 推荐的方式之一就是使用 ThreadLocal，让每个线程单独拥有这个对象。
     */
    private static final ThreadLocal<DateFormat> DATE_FORMAT_THREAD_LOCAL =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
}
