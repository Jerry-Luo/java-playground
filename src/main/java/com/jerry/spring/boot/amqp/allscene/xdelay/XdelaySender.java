package com.jerry.spring.boot.amqp.allscene.xdelay;

import com.jerry.commons.constants.CommonConst;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class XdelaySender {

    private final static Logger LOGGER = LoggerFactory.getLogger(XdelaySender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 测试不成功，经查看资料，x-delay 需要配合 rabbitmq 的延时消息队列插件
    public void send (Integer delay) {
        MessageProperties mp = new MessageProperties();
        mp.setDelay(delay);
        String msg = "test x-delay msg " + DateFormatUtils.format(new Date(), CommonConst.DATE_FORMAT_YMDHMSS);
        Message m = new Message(msg.getBytes(), mp);
        LOGGER.info("sended msg : {}", msg);
        rabbitTemplate.send("xDelayExchange","xDelayRoutingKey",m);
//        rabbitTemplate.convertAndSend("xDelayExchange","xDelayRoutingKey",msg);
    }
}
