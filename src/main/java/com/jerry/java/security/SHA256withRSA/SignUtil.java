package com.jerry.java.security.SHA256withRSA;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Base64;

/**
 * Filename      SignUtil.java
 * Description   SHA256withRSA 签名工具类
 * Copyright     Copyright (c) 2016-2022 All Rights Reserved.
 * Company       fintechzh.com Inc.
 *
 * @author 罗建伟
 * @version 1.0
 * @date 2018/7/11 17:02
 */
public class SignUtil {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SignUtil.class);

    public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
    public static final String DEGIST_ALGORITHM = "SHA-256";

    /**
     * 签名
     *
     * @param privateKey 私钥
     * @param src        明文
     * @return 签名后的数据
     */
    public static byte[] sign(PrivateKey privateKey, String src) {
        log.info("待签名内容: {}", src);
        MessageDigest messageDigest;
        byte[] signed = null;
        try {
            messageDigest = MessageDigest.getInstance(DEGIST_ALGORITHM);
            try {
                messageDigest.update(src.getBytes(RSA.CHAR_SET_NAME));
            } catch (UnsupportedEncodingException e) {
                log.error("", e);
            }
            byte[] digesttoSign = messageDigest.digest();
            log.info("SHA-256 散列后: " + toBase64String(digesttoSign));
            Signature Sign = Signature.getInstance(SIGNATURE_ALGORITHM);
            Sign.initSign(privateKey);
            Sign.update(digesttoSign);
            signed = Sign.sign();
            log.info("SHA256withRSA签名后: " + toBase64String(signed));
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            log.error("", e);
        }
        return signed;
    }

    /**
     * 包装后的签名方法，直接传入编码后的私钥字符串和待签名字符串即可生成签名
     *
     * @param privateKey 私钥字符串
     * @param src        待签名字符串
     * @return 签名后的字符串
     */
    public static String sign(String privateKey, String src) {
        PrivateKey prvt = RSA.restorePrivateKey(privateKey);
        byte[] signed = sign(prvt, src);
        return toBase64String(signed);
    }

    /**
     * 验签
     *
     * @param publicKey 公钥
     * @param src       明文
     * @param signed    签名
     */
    public static boolean verifySign(PublicKey publicKey, String src, byte[] signed) {

        MessageDigest messageDigest;
        boolean verifyResult = false;
        try {
            messageDigest = MessageDigest.getInstance(DEGIST_ALGORITHM);
            messageDigest.update(src.getBytes());
            byte[] digestToVerify = messageDigest.digest();
            Signature verifySign = Signature.getInstance(SIGNATURE_ALGORITHM);
            verifySign.initVerify(publicKey);
            verifySign.update(digestToVerify);
            verifyResult = verifySign.verify(signed);
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            log.error("", e);
        }
        return verifyResult;
    }


    /**
     * 包装的验签名方法，可支持Base64编码后的字符串公钥，及 Base64 编码后的签名字符创
     *
     * @param publicKey 公钥字符串
     * @param src       待验签字符串
     * @param signed    需要验证的签名
     * @return 验签结果
     */
    public static boolean verifySign(String publicKey, String src, String signed) {
        PublicKey pub = RSA.restorePublicKey(publicKey);
        byte[] signedBytes = Base64.getDecoder().decode(signed);
        return verifySign(pub, src, signedBytes);
    }

    /**
     * bytes[]换成16进制字符串
     *
     * @param src 待编码的byte数组
     * @return 十六进制字符串
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte aSrc : src) {
            int v = aSrc & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * bytes[]换成 BASE64 字符串
     *
     * @param src 待编码的byte数组
     * @return BASE64 字符串
     */
    public static String toBase64String(byte[] src) {
        try {
            return new String(Base64.getEncoder().encode(src), RSA.CHAR_SET_NAME);
        } catch (UnsupportedEncodingException e) {
            log.error("", e);
        }
        return null;
    }
}
