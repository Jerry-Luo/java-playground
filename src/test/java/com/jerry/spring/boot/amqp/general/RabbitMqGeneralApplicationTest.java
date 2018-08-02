package com.jerry.spring.boot.amqp.general;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(value= SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitMqGeneralApplication.class)
public class RabbitMqGeneralApplicationTest {
    @Autowired
    private Sender sender;

    @Test
    public void sendTest() throws Exception {
        while(true){
            String msg = new Date().toString();
            sender.send(msg);
            Thread.sleep(1000);
        }
    }
}