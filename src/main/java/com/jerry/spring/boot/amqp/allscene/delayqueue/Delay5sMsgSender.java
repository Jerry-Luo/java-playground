package com.jerry.spring.boot.amqp.allscene.delayqueue;

import com.jerry.commons.constants.CommonConst;
import com.jerry.commons.utils.JsonMapper;
import com.jerry.spring.boot.amqp.allscene.transferentity.User;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class Delay5sMsgSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Delay5sMsgSender.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(String expiration) {

        // 发送普通字符串消息
        String msg = "hello delay queue " + DateFormatUtils.format(new Date(), CommonConst.DATE_FORMAT_YMDHMSS);
        LOGGER.info("发送消息{}", msg);
//        rabbitTemplate.convertAndSend("delay5sQueueExchange", "delay5sQueueRoutingkey", msg);
        MessageProperties mp = new MessageProperties();
        mp.setExpiration(expiration);
//        Message message = new Message(msg.getBytes(StandardCharsets.UTF_8), mp);
//        rabbitTemplate.send("delay5sQueueExchange", "delay5sQueueRoutingkey", message);

        //发送对象
        User user = new User();
        user.setName("test delay queue");
        user.setPass("test delay pass");
        mp.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        mp.setHeader("__TypeId__", "com.jerry.spring.boot.amqp.allscene.transferentity.User");
        Message m = new Message(JsonMapper.obj2Str(user).getBytes(StandardCharsets.UTF_8), mp);
        rabbitTemplate.send("delay5sQueueExchange", "delay5sQueueRoutingkey", m);
    }

}
