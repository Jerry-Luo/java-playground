package com.jerry.spring.boot.amqp.allscene.delayqueue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DelayMqConfig {


    // 延迟队列
    @Bean
    public Queue delayQueue() {
        Map<String, Object> params = new HashMap<>();
        params.put("x-dead-letter-exchange", "delayQueueDeadLetterExchange");
        params.put("x-dead-letter-routing-key", "delayQueueWorkerRoutingkey");
//        params.put("x-message-ttl", "5000");
        return new Queue("delay5sQueue", true, false, false, params);
    }

    @Bean
    public Queue delayWorkerQueue() {
        return new Queue("delayWorkerQueue");
    }


    @Bean
    DirectExchange delayQueueDeadLetterExchange() {
        return new DirectExchange("delayQueueDeadLetterExchange");
    }

    @Bean
    DirectExchange delay5sQueueExchange() {
        return new DirectExchange("delay5sQueueExchange");
    }


    @Bean
    Binding bindingDelay5sQueueExchange(Queue delayQueue, DirectExchange delay5sQueueExchange) {
        return BindingBuilder.bind(delayQueue).to(delay5sQueueExchange).with("delay5sQueueRoutingkey");
    }

    @Bean
    Binding bindingDelayQueueDeadLetterExchange(Queue delayWorkerQueue, DirectExchange delayQueueDeadLetterExchange) {
        return BindingBuilder.bind(delayWorkerQueue).to(delayQueueDeadLetterExchange).with("delayQueueWorkerRoutingkey");
    }

}
