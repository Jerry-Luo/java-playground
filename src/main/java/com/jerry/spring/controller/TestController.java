package com.jerry.spring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class TestController {

    @PostMapping(value = "/testupload")
    public String upload(String fileName, MultipartFile jarFile) {

        // 下面是测试代码
        System.out.println(fileName);
        String originalFilename = jarFile.getOriginalFilename();

        System.out.println(originalFilename);

        try {
            String string = new String(jarFile.getBytes(), "UTF-8");

            System.out.println(string);

        } catch (IOException e) {
            e.printStackTrace();
        }
        // 处理文件内容...
        return "OK";
    }

}
