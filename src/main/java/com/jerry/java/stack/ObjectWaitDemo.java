package com.jerry.java.stack;

import java.util.concurrent.TimeUnit;

public class ObjectWaitDemo {
    public static void main(String[] args) {
        final Thread thread = new Thread() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
        thread.setName("test-thread");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (thread) {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        thread.notify();
    }
}
//"main" #1 prio=5 os_prio=31 tid=0x00007ff7fa801000 nid=0x1803 waiting on condition  [0x0000000105cff000]
//        java.lang.Thread.State: TIMED_WAITING (sleeping)
//        at java.lang.Thread.sleep(java.base@10.0.1/Native Method)
//        at java.lang.Thread.sleep(java.base@10.0.1/Thread.java:340)
//        at java.util.concurrent.TimeUnit.sleep(java.base@10.0.1/TimeUnit.java:403)
//        at com.jerry.java.stack.ObjectWaitDemo.main(ObjectWaitDemo.java:32)
//        - locked <0x00000006cfb3cb28> (a com.jerry.java.stack.ObjectWaitDemo$1)

//"test-thread" #13 prio=5 os_prio=31 tid=0x00007ff7fa08f800 nid=0x9403 in Object.wait()  [0x0000700004da7000]
//        java.lang.Thread.State: WAITING (on object monitor)
//        at java.lang.Object.wait(java.base@10.0.1/Native Method)
//        - waiting on <0x00000006cfb3cb28> (a com.jerry.java.stack.ObjectWaitDemo$1)
//        at java.lang.Object.wait(java.base@10.0.1/Object.java:328)
//        at com.jerry.java.stack.ObjectWaitDemo$1.run(ObjectWaitDemo.java:13)
//        - waiting to re-lock in wait() <0x00000006cfb3cb28> (a com.jerry.java.stack.ObjectWaitDemo$1)