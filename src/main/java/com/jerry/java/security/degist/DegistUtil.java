//package com.jerry.java.security.degist;
//
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.*;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.Base64;
///**
// * Filename      DegistUtil.java
// * Description   计算摘要工具类
// * Copyright     Copyright (c) 2016-2022 All Rights Reserved.
// * Company       fintechzh.com Inc.
// * @author       罗建伟
// * @date         2018/7/12 16:06
// * @version      1.0
// */
//@Slf4j
//public class DegistUtil {
//
//    public static final String DEGIST_ALGORITHM    = "SHA-256";
//
//
//    public static byte[] degist (byte[] src) {
//        MessageDigest messageDigest;
//        try {
//            messageDigest = MessageDigest.getInstance(DEGIST_ALGORITHM);
//            messageDigest.update(src);
//            return messageDigest.digest();
//        } catch (NoSuchAlgorithmException e) {
//            log.error("", e);
//        }
//        return null;
//    }
//
//    public static String degist (InputStream inputStream) {
//        try {
//            byte[] src = new byte[inputStream.available()];
//            inputStream.read(src);
//            byte[] dr = degist(src);
//            return new String(Base64.getEncoder().encode(dr));
//        } catch (IOException e) {
//            log.error("", e);
//        }
//        return null;
//    }
//
//    public static String degist(String path) {
//        File f = new File(path);
//        if (f.exists() && f.isFile()) {
//            try {
//                InputStream in = new FileInputStream(f);
//                return degist(in);
//            } catch (FileNotFoundException e) {
//                log.error("", e);
//            }
//        }
//        return null;
//    }
//
//    public static boolean verifyDegist (InputStream inputStream, String degist) {
//        return degist.equals(degist(inputStream));
//    }
//
//    public static void main(String[] args) throws FileNotFoundException {
//        long start = System.currentTimeMillis();
//        String filePath = "/Users/Jerry/Downloads/1528342643470.csv";
//        String degistResult = DegistUtil.degist(filePath);
//        System.out.println(degistResult);
//
//        filePath = "/Users/Jerry/Downloads/1528342643472.csv";
//        InputStream in = new FileInputStream(new File(filePath));
//        System.out.println(DegistUtil.verifyDegist(in, degistResult));
//        System.out.println(System.currentTimeMillis() - start);
//    }
//}
