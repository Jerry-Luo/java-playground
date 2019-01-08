package com.jerry.java.spi.impl;

import com.jerry.java.spi.service.DogService;

public class WhiteDogServiceImpl implements DogService {
    @Override
    public void sleep() {
        System.out.println("白色 dog, 呼呼大睡。。。");
    }
}
