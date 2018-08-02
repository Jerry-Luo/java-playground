package com.jerry.spring.boot.amqp.general;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Sender implements RabbitTemplate.ConfirmCallback, ReturnCallback, InitializingBean {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("消息发送成功:" + correlationData);
        } else {
            System.out.println("消息发送失败:" + cause);
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println(message.getMessageProperties().getCorrelationId() + " 发送失败");

    }

    //发送消息，不需要实现任何接口，供外部调用。
    public void send(String msg){

//        rabbitTemplate.send(message);   //发消息，参数类型为org.springframework.amqp.core.Message
//        rabbitTemplate.convertAndSend(object); //转换并发送消息。 将参数对象转换为org.springframework.amqp.core.Message后发送
//        rabbitTemplate.convertSendAndReceive(message) //转换并发送消息,且等待消息者返回响应消息。

        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());

        System.out.println("开始发送消息 : " + msg.toLowerCase());
        String response = rabbitTemplate.convertSendAndReceive("topicExchange", "key.1", msg, correlationId).toString();
        System.out.println("结束发送消息 : " + msg.toLowerCase());
        System.out.println("消费者响应 : " + response + " 消息处理完成");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }
}