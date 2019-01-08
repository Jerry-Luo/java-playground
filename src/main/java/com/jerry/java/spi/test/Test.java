package com.jerry.java.spi.test;

import com.jerry.java.spi.service.DogService;

import java.util.ServiceLoader;

/**
 * java 的 spi 运行流程是运用 java.util.ServiceLoader 这个类的 load 方法去在 src/META-INF/services/ 寻找对应的全路径接口名称的文件，
 * 然后在文件中找到对应的实现方法并注入实现，然后你可以运用了
 * jdk1.8 下测试成功
 *
 * 1.9以上测试不会输出
 * 原因：通过跟踪jdk11源码 -> java.util.ServiceLoader.LazyClassPathLookupIterator#hasNextService()
 * if (clazz.getModule().isNamed()) 判断为 true 结果配置的 serviceImpl 被忽略掉了
 * // TODO: 2019-01-08 暂未找到解决办法，后续需要系统地学习下 Java 模块化知识
 */
public class Test {

    public static void main(String[] args) {

        Module module1 = Test.class.getModule();
        Module module2 = Test.class.getClassLoader().getUnnamedModule();
        System.out.println(module1 == module2);

        ServiceLoader<DogService> dogServices = ServiceLoader.load(DogService.class);
//        ServiceLoader<DogService> dogServices = ServiceLoader.load(Test.class.getClassLoader().getUnnamedModule().getLayer(), DogService.class);
        for (DogService dogService : dogServices) {
            dogService.sleep();
        }
    }
}
