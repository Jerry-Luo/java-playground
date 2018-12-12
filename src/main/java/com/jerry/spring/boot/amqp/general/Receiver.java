package com.jerry.spring.boot.amqp.general;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 由于定义了2个队列，所以分别定义不同的监听器监听不同的队列。
 * 由于最小消息监听线程数和最大消息监听线程数都是2，所以每个监听器各有2个线程实现监听功能。
 * <p>
 * 1.监听器参数类型与消息实际类型匹配。在生产者中发送的消息实际类型是String，所以这里监听器参数类型也是String。
 * 2.如果监听器需要有响应返回给生产者，直接在监听方法中return即可。
 */
@Component
public class Receiver {

    @RabbitListener(queues = "hello.queue1")
    public String processMessage1(String msg) {
        System.out.println(Thread.currentThread().getName() + " 接收到来自hello.queue1队列的消息：" + msg);
        return msg.toUpperCase();
    }

    @RabbitListener(queues = "hello.queue2")
    public void processMessage2(String msg) {
        System.out.println(Thread.currentThread().getName() + " 接收到来自hello.queue2队列的消息：" + msg);
    }
}