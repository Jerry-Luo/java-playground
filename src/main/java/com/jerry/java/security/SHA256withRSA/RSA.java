//package com.jerry.java.security.SHA256withRSA;
//
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.UnsupportedEncodingException;
//import java.security.KeyFactory;
//import java.security.KeyPair;
//import java.security.KeyPairGenerator;
//import java.security.NoSuchAlgorithmException;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.security.interfaces.RSAPrivateKey;
//import java.security.interfaces.RSAPublicKey;
//import java.security.spec.InvalidKeySpecException;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//import java.util.Base64;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Filename      RSA.java
// * Description   生成 RSA 密钥对
// * Copyright     Copyright (c) 2016-2022 All Rights Reserved.
// * Company       fintechzh.com Inc.
// * @author       罗建伟
// * @date         2018/7/11 17:02
// * @version      1.0
// */
//@Slf4j
//public class RSA {
//
//    public static final String KEY_ALGORITHM = "RSA";
//    public static final String PUBLIC_KEY    = "publicKey";
//    public static final String PRIVATE_KEY   = "privateKey";
//    public static final int    KEY_SIZE      = 2048;
//    public static final String CHAR_SET_NAME = "UTF-8";
//
//    /**
//     * 生成密钥对
//     * @return 密钥对
//     */
//    public static Map<String, byte[]> generateKeyBytes() {
//        try {
//            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
//            keyPairGenerator.initialize(KEY_SIZE);
//            KeyPair keyPair = keyPairGenerator.generateKeyPair();
//            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
//            Map<String, byte[]> keyMap = new HashMap<>();
//            keyMap.put(PUBLIC_KEY, publicKey.getEncoded());
//            keyMap.put(PRIVATE_KEY, privateKey.getEncoded());
//            return keyMap;
//        } catch (NoSuchAlgorithmException e) {
//            log.error("生成密钥对失败", e);
//        }
//        return null;
//    }
//
//    /**
//     * 生成 Base64 编码后的密钥对
//     * @return Base64 编码后的密钥对
//     */
//    public static Map<String, String> generateBase64KeyPair() {
//        Map<String, byte[]> keyPair = generateKeyBytes();
//        Map<String, String> result = new HashMap<>();
//        try {
//            byte[] pub = Base64.getEncoder().encode(keyPair.get(PUBLIC_KEY));
//            byte[] prvt = Base64.getEncoder().encode(keyPair.get(PRIVATE_KEY));
//            result.put(PUBLIC_KEY, new String(pub, CHAR_SET_NAME));
//            result.put(PRIVATE_KEY, new String(prvt, CHAR_SET_NAME));
//        } catch (UnsupportedEncodingException e) {
//            log.error("", e);
//        }
//        return result;
//    }
//
//    /**
//     * 还原公钥
//     * @param keyBytes keyBytes
//     * @return PublicKey
//     */
//    public static PublicKey restorePublicKey(byte[] keyBytes) {
//        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
//        try {
//            KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
//            return factory.generatePublic(x509EncodedKeySpec);
//        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
//            log.error("", e);
//        }
//        return null;
//    }
//
//    /**
//     * 还原 Base64 编码后的公钥
//     * @param base64PubKey base64PubKey
//     * @return PublicKey
//     */
//    public static PublicKey restorePublicKey(String base64PubKey) {
//        byte[] pub = null;
//        try {
//            pub = Base64.getDecoder().decode(base64PubKey.getBytes(CHAR_SET_NAME));
//        } catch (UnsupportedEncodingException e) {
//            log.error("", e);
//        }
//        return restorePublicKey(pub);
//    }
//
//    /**
//     * 还原私钥
//     *
//     * @param keyBytes keyBytes
//     * @return PrivateKey
//     */
//    public static PrivateKey restorePrivateKey(byte[] keyBytes) {
//        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
//        try {
//            KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
//            return factory.generatePrivate(pkcs8EncodedKeySpec);
//        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
//            log.error("", e);
//        }
//        return null;
//    }
//
//    /**
//     * 还原 Base64 编码后的私钥
//     * @param base64PrvtKey base64PrvtKey
//     * @return PrivateKey
//     */
//    public static PrivateKey restorePrivateKey(String base64PrvtKey) {
//        byte[] prvt = null;
//        try {
//            prvt = Base64.getDecoder().decode(base64PrvtKey.getBytes(CHAR_SET_NAME));
//        } catch (UnsupportedEncodingException e) {
//            log.error("", e);
//        }
//        return restorePrivateKey(prvt);
//    }
//}
