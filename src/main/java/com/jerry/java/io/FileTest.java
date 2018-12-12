package com.jerry.java.io;

import org.springframework.amqp.core.DirectExchange;

import javax.xml.transform.Source;
import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException {
        String path = "/opt/test/protocol/contract/20181020/1539930986846-1538040970291-ZHLC-20180927-1.pdf";
        File f = new File(path);
        new FileOutputStream(f).write("haha".getBytes("UTF-8"));
        System.out.println(f.getParentFile().getName());

    }
}
