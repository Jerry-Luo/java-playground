module javaplayground {
    exports com.jerry.spring.boot.amqp.general;
    opens com.jerry.spring.boot.amqp.general;
    exports com.jerry.spring.boot.amqp.allscene.onetoone;
    opens com.jerry.spring.boot.amqp.allscene.onetoone;
    exports com.jerry.spring.boot.amqp.allscene;
    opens com.jerry.spring.boot.amqp.allscene;
    exports com.jerry.spring.boot.amqp.allscene.onetomany;
    opens com.jerry.spring.boot.amqp.allscene.onetomany;
    exports com.jerry.spring.boot.amqp.allscene.manytomany;
    opens com.jerry.spring.boot.amqp.allscene.manytomany;
    exports com.jerry.spring.boot.amqp.allscene.transferentity;
    opens com.jerry.spring.boot.amqp.allscene.transferentity;
    exports com.jerry.spring.boot.amqp.allscene.topic;
    opens com.jerry.spring.boot.amqp.allscene.topic;
    exports com.jerry.spring.boot.amqp.allscene.fanout;
    opens com.jerry.spring.boot.amqp.allscene.fanout;
    exports com.jerry.spring.boot.amqp.allscene.callback;
    opens com.jerry.spring.boot.amqp.allscene.callback;
    exports com.jerry.spring.boot.amqp.allscene.delayqueue;
    opens com.jerry.spring.boot.amqp.allscene.delayqueue;
    exports com.jerry.spring.boot.amqp.allscene.xdelay;
    opens com.jerry.spring.boot.amqp.allscene.xdelay;

//    exports com.jerry.java.spi.service;
//    opens com.jerry.java.spi.service;
//    exports com.jerry.java.spi.impl;
//    opens com.jerry.java.spi.impl;
    uses com.jerry.java.spi.service.DogService;
//    uses com.jerry.java.spi.impl.BlackDogServiceImpl;
//    uses com.jerry.java.spi.impl.WhiteDogServiceImpl;

    requires spring.amqp;
    requires spring.rabbit;
    requires spring.messaging;
    requires spring.beans;
    requires spring.context;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.web;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires spring.expression;

//    requires lombok;
    requires aspectjweaver;
    requires com.rabbitmq.client;
    requires java.management;
    requires java.logging;
    requires java.annotation;
    requires slf4j.api;
    requires java.sql;
    requires org.apache.commons.lang3;
    requires jackson.annotations;
}