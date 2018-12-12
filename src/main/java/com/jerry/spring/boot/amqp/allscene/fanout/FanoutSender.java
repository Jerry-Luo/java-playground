package com.jerry.spring.boot.amqp.allscene.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msgString = "fanoutSender -> hello i am 张三";
        System.out.println(msgString);
        this.rabbitTemplate.convertAndSend("FanoutExchange", "abcd.ee", msgString);
    }
}
