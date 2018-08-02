package com.jerry.mq.rabbitmq.delayqueue;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class Producer {
    private static String queue_name = "test.queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        byte i = 1;
//        while (i-- > 0) {
        while (i++ <= 10) {
//            channel.basicPublish("queue1", "queue1", new AMQP.BasicProperties.Builder().expiration(String.valueOf(i * 1000)).build(),
//                    new byte[] { i });

            channel.basicPublish("queue1", "queue1", new AMQP.BasicProperties.Builder().expiration(String.valueOf(i*3000)).build(),
                    new byte[] { i });
        }
        System.out.println("发送完消息 " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

        // 关闭频道和连接
        channel.close();
        connection.close();
    }

}


