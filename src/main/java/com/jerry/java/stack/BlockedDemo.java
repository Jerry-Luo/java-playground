package com.jerry.java.stack;

import java.util.concurrent.TimeUnit;

public class BlockedDemo {
    public static void main(String[] args) {
        final Thread thread = new Thread() {
            @Override
            public void run(){
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName() + "   1");
                    try {
                        TimeUnit.SECONDS.sleep(60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
        thread.setName("Thread1");
        synchronized (thread) {
            System.out.println(Thread.currentThread().getName() + "   2");
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//"main" #1 prio=5 os_prio=31 tid=0x00007f9d80802800 nid=0x1a03 waiting on condition  [0x000000010fbf8000]
//        java.lang.Thread.State: TIMED_WAITING (sleeping)
//        at java.lang.Thread.sleep(java.base@10.0.1/Native Method)
//        at java.lang.Thread.sleep(java.base@10.0.1/Thread.java:340)
//        at java.util.concurrent.TimeUnit.sleep(java.base@10.0.1/TimeUnit.java:403)
//        at com.jerry.java.stack.BlockedDemo.main(BlockedDemo.java:25)
//        - locked <0x00000006cfcca1e0> (a com.jerry.java.stack.BlockedDemo$1)

//"Thread1" #13 prio=5 os_prio=31 tid=0x00007f9d808c9800 nid=0x7003 waiting for monitor entry  [0x0000700007bc2000]
//        java.lang.Thread.State: BLOCKED (on object monitor)
//        at com.jerry.java.stack.BlockedDemo$1.run(BlockedDemo.java:11)
//        - waiting to lock <0x00000006cfcca1e0> (a com.jerry.java.stack.BlockedDemo$1)


