package com.jerry.spring.boot.amqp.allscene.delayqueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.jerry.spring.boot.amqp.allscene.transferentity.User;

@Component
@RabbitListener(queues = "delayWorkerQueue")
public class Delay5sMsgReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Delay5sMsgReceiver.class);

//    @RabbitHandler
//    public void handleMsg(byte[] msg) {
//        LOGGER.info("receive msg: {}", new String(msg));
//    }

    @RabbitHandler
    public void handleUser(User user) {
        LOGGER.info("receive msg: name->{}, pass->{}", user.getName(), user.getPass());
    }
}
