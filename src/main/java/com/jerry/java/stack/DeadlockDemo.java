package com.jerry.java.stack;

public class DeadlockDemo {
    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
    }
}

class ThreadA extends Thread {
    public void run () {
        System.out.println("-----------A-----------");
        synchronized (A.A) {
            System.out.println("我要开始执行任务A, " + Thread.currentThread());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (B.B) {
                System.out.println("A->B");
            }

            System.out.println("A 执行结束 " + Thread.currentThread().getName() + ":" + B.B.hashCode() + ":" + A.A.hashCode());
        }
    }
}

class ThreadB extends Thread {
    public void run () {
        System.out.println("-----------B-----------");
        synchronized (B.B) {
            System.out.println("我要开始执行任务B, " + Thread.currentThread());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (A.A) {
                System.out.println("B->A");
            }

            System.out.println("B 执行结束 " + Thread.currentThread().getName() + ":" + B.B + " : " + A.A);
        }
    }
}

class A {
    static final Integer A =  Integer.valueOf("1");
}

class B {
    static final Integer B =  Integer.valueOf("3");
}

//"Thread-0" #13 prio=5 os_prio=31 tid=0x00007fb0100d3000 nid=0x8d03 waiting for monitor entry  [0x000070000a2e0000]
//        java.lang.Thread.State: BLOCKED (on object monitor)
//        at com.jerry.java.stack.ThreadA.run(DeadlockDemo.java:22)
//        - waiting to lock <0x00000006cff20c50> (a java.lang.Integer)
//        - locked <0x00000006cff20c30> (a java.lang.Integer)

//"Thread-1" #14 prio=5 os_prio=31 tid=0x00007fb011860800 nid=0x8a03 waiting for monitor entry  [0x000070000a3e3000]
//        java.lang.Thread.State: BLOCKED (on object monitor)
//        at com.jerry.java.stack.ThreadB.run(DeadlockDemo.java:42)
//        - waiting to lock <0x00000006cff20c30> (a java.lang.Integer)
//        - locked <0x00000006cff20c50> (a java.lang.Integer)