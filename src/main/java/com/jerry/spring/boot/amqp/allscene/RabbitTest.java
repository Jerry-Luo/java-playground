package com.jerry.spring.boot.amqp.allscene;

import com.jerry.spring.boot.amqp.allscene.delayqueue.Delay5sMsgSender;
import com.jerry.spring.boot.amqp.allscene.xdelay.XdelaySender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jerry.spring.boot.amqp.allscene.callback.CallBackSender;
import com.jerry.spring.boot.amqp.allscene.fanout.FanoutSender;
import com.jerry.spring.boot.amqp.allscene.manytomany.ManyToManySenderOne;
import com.jerry.spring.boot.amqp.allscene.manytomany.ManyToManySenderTwo;
import com.jerry.spring.boot.amqp.allscene.onetomany.OneToManySender;
import com.jerry.spring.boot.amqp.allscene.onetoone.OneToOneSender;
import com.jerry.spring.boot.amqp.allscene.topic.TopicSender;
import com.jerry.spring.boot.amqp.allscene.transferentity.TransferEntitySender;

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

    @Autowired
    private OneToOneSender oneToOneSender;
    @Autowired
    private OneToManySender oneToManySender;
    @Autowired
    private ManyToManySenderOne manyToManySenderOne;
    @Autowired
    private ManyToManySenderTwo manyToManySenderTwo;
    @Autowired
    private TransferEntitySender transferEntitySender;
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private CallBackSender callBackSender;
    @Autowired
    private Delay5sMsgSender delay5sMsgSender;
    @Autowired
    private XdelaySender xdelaySender;

    @PostMapping("/hello")
    public void hello() {
        oneToOneSender.send();
    }

    /**
     * 单生产者-多消费者
     */
    @PostMapping("/oneToMany")
    public void oneToMany() {
        for(int i=0;i<10;i++){
            oneToManySender.send("hellomsg:"+i);
        }
    }

    /**
     * 多生产者-多消费者
     */
    @PostMapping("/manyToMany")
    public void manyToMany() {
        for(int i=0;i<10;i++){
            manyToManySenderOne.send("manyToManySenderOne:"+i);
            manyToManySenderTwo.send("manyToManySenderTwo:"+i);
        }
    }

    /**
     * 实体类传输测试
     */
    @PostMapping("/userTest")
    public void userTest() {
        transferEntitySender.send();
    }

    /**
     * topic exchange类型rabbitmq测试
     */
    @PostMapping("/topicTest")
    public void topicTest() {
        topicSender.send();
    }

    /**
     * fanout exchange类型rabbitmq测试
     */
    @PostMapping("/fanoutTest")
    public void fanoutTest() {
        fanoutSender.send();
    }

    @PostMapping("/callback")
    public void callbak() {
        callBackSender.send();
    }

    @PostMapping("/delayQueue")
    public void delayQueue(String expiration) {
        delay5sMsgSender.send(expiration);
    }

    //测试不成功，经查看资料，x-delay 需要配合 rabbitmq 的延时消息队列插件
    @PostMapping("/xdelay")
    public void delayQueue(Integer delay) {
        xdelaySender.send(delay);
    }
}
