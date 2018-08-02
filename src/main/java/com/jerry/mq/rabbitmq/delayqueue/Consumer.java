package com.jerry.mq.rabbitmq.delayqueue;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Consumer {
    private static String queue_name = "test.queue";

    public static void main(String[] args) throws Exception {



        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.basicConsume("Queue2", true, "consumer", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                long deliveryTag = envelope.getDeliveryTag();
                //do some work async
                System.out.println(body[0] +" " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        });
    }

}
