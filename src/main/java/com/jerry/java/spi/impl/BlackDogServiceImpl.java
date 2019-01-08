package com.jerry.java.spi.impl;

import com.jerry.java.spi.service.DogService;

public class BlackDogServiceImpl implements DogService {
    @Override
    public void sleep() {
        System.out.println("黑色 dog, 汪汪叫, 不睡觉。。。");
    }
}
