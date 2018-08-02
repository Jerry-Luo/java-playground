package com.jerry.spring.boot.amqp.allscene.xdelay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "xDelayQueue")
public class XdelayReceiver {
    private final static Logger LOGGER = LoggerFactory.getLogger(XdelayReceiver.class);

    @RabbitHandler
    public void handle(byte[] msg) {
        LOGGER.info("receive msg : {}", new String(msg));
    }

//    @RabbitHandler
//    public void handleString(String msg) {
//        LOGGER.info("receive msg : {}", msg);
//    }
}
