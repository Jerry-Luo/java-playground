package com.jerry.spring.boot.amqp.allscene.transferentity;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransferEntitySender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        User user = new User();
        user.setName("张三");
        user.setPass("123456789");
        System.out.println("user send : " + user.getName() + "/" + user.getPass());
        this.rabbitTemplate.convertAndSend("DirectExchange", "userQueue", user);
    }
}
