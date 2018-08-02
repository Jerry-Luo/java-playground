package com.jerry.java.concurrency.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * 读写锁看起来比 synchronized 的粒度似乎细一些，但在实际应用中，其表现也并不尽如人意，主要还是因为相对比较大的开销。
 * 所以，JDK 在后期引入了 StampedLock，在提供类似读写锁的同时，还支持优化读模式。
 * 优化读基于假设，大多数情况下读操作并不会和写操作冲突，其逻辑是先试着修改，然后通过 validate 方法确认是否进入了写模式，
 * 如果没有进入，就成功避免了开销；如果进入，则尝试获取读锁。请参考我下面的样例代码。
 *
 * 注意，这里的 writeLock 和 unLockWrite 一定要保证成对调用。
 */
public class StampedSample {
    private final StampedLock sl = new StampedLock();

    void mutate() {
        long stamp = sl.writeLock();
        try {
//            write();
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    Object access() {
        long stamp = sl.tryOptimisticRead();
//        Object data = read();
        if (!sl.validate(stamp)) {
            stamp = sl.readLock();
            try {
//                data = read();
            } finally {
                sl.unlockRead(stamp);
            }
        }
//        return data;
        return null;
    }
    // …
}