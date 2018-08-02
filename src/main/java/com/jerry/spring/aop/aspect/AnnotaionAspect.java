//package com.jerry.spring.aop.aspect;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//// 申明这是一个组件
//@Component
//// 申明这是一个切面 bean
//@Aspect
//@Slf4j
//public class AnnotaionAspect {
//
//    // 切点表达式怎么定义参考 https://docs.spring.io/spring/docs/5.0.7.RELEASE/spring-framework-reference/core.html#aop-pointcuts
//    // 配置切入点，该方法无方法体，主要为方便同类中其他方法使用此处配置的切入点
//    @Pointcut("execution(* com.jerry.spring.aop.service..*(..))")
//    public void aspect() {}
//
//    // 配置前置增强，使用在方法 aspect() 上注册的切入点
//    // 同事接收 JoinPoint 切入点对象，可以没有该参数
//    @Before("aspect()")
//    public void before(JoinPoint joinPoint) {
//        log.info("before " + joinPoint);
//    }
//
//    // 配置后置增强，使用在方法 aspect() 上注册的切入点
//    @After("aspect()")
//    public void after (JoinPoint joinPoint) {
//        log.info("after " + joinPoint);
//    }
//
//    // 配置环绕增强，使用在方法 aspect() 上注册的切入点
//    @Around("aspect()")
//    public void around (JoinPoint joinPoint) {
//        long start = System.currentTimeMillis();
//        try {
//            ((ProceedingJoinPoint) joinPoint).proceed();
//            long end = System.currentTimeMillis();
//            log.info("around " + joinPoint + "\t Use time : " + (end - start) + " ms!");
//        } catch (Throwable throwable) {
//            long end = System.currentTimeMillis();
//            log.info("around " + joinPoint + "\t Use time: " + (end - start) + " ms whith exception : " + throwable.getMessage());
//        }
//    }
//
//    // 配置后置返回增强，使用在方法 aspect() 上注册的切入点
//    @AfterReturning("aspect()")
//    public void afterReturn (JoinPoint joinPoint) {
//        log.info("afterReturn " + joinPoint);
//    }
//
//    // 配置抛出异常后的增强，使用在方法 aspect() 上注册的切入点
//    public void afterThrow(JoinPoint joinPoint, Exception ex) {
//        log.info("afterThrow " + joinPoint + "\t" + ex.getMessage());
//    }
//}
