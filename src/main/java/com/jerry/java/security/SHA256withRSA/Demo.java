package com.jerry.java.security.SHA256withRSA;

import java.util.Map;

public class Demo {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Demo.class);

    public static final String PLAIN_TEXT = "test string hello sha256withrsa";

    public static void main(String[] args) {
        // 公私钥对
//        Map<String, byte[]> keyMap = RSA.generateKeyBytes();
//        PublicKey publicKey = RSA.restorePublicKey(keyMap.get(RSA.PUBLIC_KEY));
//        PrivateKey privateKey = RSA.restorePrivateKey(keyMap.get(RSA.PRIVATE_KEY));
//        // 签名
//        byte[] sing_byte = SignUtil.sign(privateKey, PLAIN_TEXT);
//        // 验签
//        SignUtil.verifySign(publicKey, PLAIN_TEXT, sing_byte);


        Map<String, String> keyPairMap = RSA.generateBase64KeyPair();
        String signResult = SignUtil.sign(keyPairMap.get(RSA.PRIVATE_KEY), PLAIN_TEXT);
        log.info("签名结果: {}", signResult);

        boolean verifyResult = SignUtil.verifySign(keyPairMap.get(RSA.PUBLIC_KEY), "test string hello sha256withrsa", signResult);
        log.info("验签结果: {}" , verifyResult);
    }

}
