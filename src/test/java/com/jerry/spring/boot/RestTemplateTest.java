package com.jerry.spring.boot;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;

public class RestTemplateTest {
    @Test
    public void testUpload() throws Exception {

//        String url = "http://127.0.0.1:8080/testupload";
        String url = "http://zheasyloantest.oss-cn-hangzhou.aliyuncs.com/1528342643470.csv?Expires=1531227873&OSSAccessKeyId=LTAIGqsL7aau4PnG&Signature=USxueM5ARf1nKMu7Bx3SdIhZvsk%3D";

//        String filePath = "/Users/Jerry/Downloads/test.txt";
        String filePath = "/Users/Jerry/Downloads/1528342643470.csv";

        RestTemplate rest = new RestTemplate();
        FileSystemResource resource = new FileSystemResource(new File(filePath));
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("jarFile", resource);
        param.add("fileName", "test.txt");

//        String string = rest.postForObject(url, param, String.class);
//        System.out.println(string);

        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(param);
        ResponseEntity<String> responseEntity = rest.exchange(url, HttpMethod.PUT, httpEntity, String.class);
        System.out.println(responseEntity.getBody());
    }

}
