package com.jerry.spring.boot.amqp.allscene.xdelay;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XdelayConfig {
    @Bean
    public Queue xDelayQueue() {
        return new Queue("xDelayQueue");
    }

    @Bean
    public DirectExchange xDelayExchange() {
        return new DirectExchange("xDelayExchange");
    }

    @Bean
    public Binding xDelayBinding(Queue xDelayQueue, DirectExchange xDelayExchange) {
        return BindingBuilder.bind(xDelayQueue).to(xDelayExchange).with("xDelayRoutingKey");
    }
}
