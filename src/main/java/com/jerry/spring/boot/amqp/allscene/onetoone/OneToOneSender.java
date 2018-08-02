package com.jerry.spring.boot.amqp.allscene.onetoone;

import com.jerry.commons.constants.CommonConst;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OneToOneSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String sendMsg = "hello1 " + DateFormatUtils.format(new Date(), CommonConst.DATE_FORMAT_YMDHMSS);
        System.out.println("Sender1 : " + sendMsg);
        rabbitTemplate.convertAndSend("DirectExchange", "helloQueue", sendMsg);
    }

}