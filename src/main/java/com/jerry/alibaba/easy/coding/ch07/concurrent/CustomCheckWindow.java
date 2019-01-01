package com.jerry.alibaba.easy.coding.ch07.concurrent;

import java.util.concurrent.Semaphore;

public class CustomCheckWindow {

    public static void main(String[] args) {
        // 设定 3 个信号量，即 3 哥服务窗口
        Semaphore semaphore = new Semaphore(3);

        // 这个队伍排了 5 个人
        for (int i = 1; i <= 5; i++) {
            new SecurityCheckThread(i, semaphore).start();
        }
    }

    private static class SecurityCheckThread extends Thread {
        private int seq;
        private Semaphore semaphore;

        public SecurityCheckThread(int seq, Semaphore semaphore) {
            this.seq = seq;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("["+Thread.currentThread().getName()+"] " + "No." + seq + " 乘客，正在检验中");

                if (seq % 2 == 0) {
                    Thread.sleep(1000);
                    System.out.println("["+Thread.currentThread().getName()+"] " + "No." + seq + "乘客，身份可疑，不能出国！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                semaphore.release();
                System.out.println("["+Thread.currentThread().getName()+"] " + "No." + seq + "乘客已完成服务。");
            }
        }
    }
}
