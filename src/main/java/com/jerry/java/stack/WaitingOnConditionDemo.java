package com.jerry.java.stack;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class WaitingOnConditionDemo {

    private static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {
        blockingQueue.add("test-blocking-queue");
        try {
            //阻塞的添加
            blockingQueue.put("blocked");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//"main" #1 prio=5 os_prio=31 tid=0x00007fed0b001800 nid=0x1a03 waiting on condition  [0x0000000105e9f000]
//        java.lang.Thread.State: WAITING (parking)
//        at jdk.internal.misc.Unsafe.park(java.base@10.0.1/Native Method)
//        - parking to wait for  <0x00000006cfcc9948> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
//        at java.util.concurrent.locks.LockSupport.park(java.base@10.0.1/LockSupport.java:194)
//        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(java.base@10.0.1/AbstractQueuedSynchronizer.java:2075)
//        at java.util.concurrent.ArrayBlockingQueue.put(java.base@10.0.1/ArrayBlockingQueue.java:367)
//        at com.jerry.java.stack.WaitingOnConditionDemo.main(WaitingOnConditionDemo.java:14)
