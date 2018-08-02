//package com.jerry.spring.aop.aspect;
//
//import com.jerry.spring.aop.service.TestService;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.*;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@Slf4j
//public class AnnotaionAspectTest {
//
//    @Autowired
//    private TestService testService;
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Test
//    public void test() {
//        log.info("=============================");
//
//        AnnotaionAspect aspect = applicationContext.getBean(AnnotaionAspect.class);
//        log.info(aspect.toString());
//
//        testService.sayHello("Jerry");
//
//        log.info("============================");
//
//        try {
//            testService.sayHelloWithException();
//        } catch (Exception e) {
//            log.error("" , e);
//        }
//    }
//}