package com.jerry.java.security.SHA256withRSA;

import java.util.Map;
import java.util.TreeMap;

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


//        Map<String, String> keyPairMap = RSA.generateBase64KeyPair();
//        String signResult = SignUtil.sign(keyPairMap.get(RSA.PRIVATE_KEY), PLAIN_TEXT);
//        log.info("签名结果: {}", signResult);
//
//        boolean verifyResult = SignUtil.verifySign(keyPairMap.get(RSA.PUBLIC_KEY), "test string hello sha256withrsa", signResult);
//        log.info("验签结果: {}" , verifyResult);


        TreeMap<String, Object> param = new TreeMap<>();
        param.put("bankCardNo", "6228480626560919377");
        param.put("channel", "000001");
        param.put("cusParam", "stringcusParam");
        param.put("email", "jianwei@outlook.com");
        param.put("idCard", "440881199212070639");
        param.put("gender", "M");
        param.put("machineType", "02");
        param.put("mobile", "18358120726");
        param.put("name", "麦福园");
        param.put("notifyUrl", "https://www.baidu.com/");
        param.put("outTradeNo", "111231231312342");
        param.put("partnerId", "33010001");
        param.put("redirectUrl", "https://www.baidu.com/");

        StringBuilder sb = new StringBuilder();
        for (Map.Entry e : param.entrySet()) {
            sb.append(e.getValue());
        }
        String pk = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDbylSDtk5Ii/IZjzVdMCw0k2rDu0lIIe94DrDpkhl43ZKqs0NcGTQl7MyWOq6vIvOajDenGq+WZmQLEy74D2fJeAhZuu81VLyHXKI6mWc4zQtSUHBv2OUnJuJU1ZPjiY67YcNU1kqSBSdG+WUI8FRh/h+Z3xalkNPCGrRotAz/z34xCcHaPqVknLRTVYoVk6fuw1Hk1xkmiCk9ruxGiIF7Dkv5LEmBYyk4CgHT10BA9zobwggfJh4WrVaFIoT0Wog3NYpyGaPzkhvoxlobm66DGza973wkB7B50KkzQX+6Gu3631UXzT0OkOIMkAGFCSTEL96OF4U3W2e+Q6jJ8gg/AgMBAAECggEBAMH0HXqRoSlh3cXyW0wd25SV1mxdVIDD+Zd/l1y2oaXIGcprIPEgCKXC/pM/u7EvbbsfK2laIkLdnkErr5IVvifKtcvBK6BrY2csNrjxcGZugyQjeeUpiKZxKN9mDfiIBh2TWxT9eZa713pJUIB/3GcRIv/dHxYB5OxwNm4DHUmLRTLYaft8byHIECGXP/laCpx8i46ODl5aAaaqn5osypZAmrXmcAkFONGyeEihOBFiKV+QO3bSbTgSoC2E6GKiIvXNnmqc9rngsce/bKbtAEwGVFtzebKwWSy0akWJZWgODBlyYDeaDx3Ydb/qVhsPcdfuYVDSZnvB4sMibgNjhAECgYEA92Nb4r+m3DLxY75/FWnC8ljNlij2lbasrQ1PHHAaJer3qxuJSoTMvGWLWwDEuLcViZKlqVhD5CgGkAey6lUu6qFtLT2FSZKv3mCaPCbohtJnxAThrQbSkj8iXQi9eyC69npm2NjrxOBRTKhRC5/VfdaCOUmIV0r1AQDQ8P35Vj8CgYEA43EHbhO7/ycO1ALjfUl2QfHOMf9Nwr93jTOb3ZL1xV2jZr0YuFmxu61NOryhzNVZQGCOfr/hoyvE9XR1Y9B779kgHoZKrj+v8XARpQDqB6RZIJpKTSwdqZb2dGLFBZ1/lt0n5JDitKkvH4CaGlU0O3xfB3caTv5QBLkdGobuzgECgYBx9+Qs4f4NE6sBOJFzW/Xjj+Wmd9ihwDZswuTfRQXG0iinO1hUbDml0WIR2pjGQBI7/sMy8ObWBVqAoAtcyUGD9jpFzUHKUzmSSQ7FB2e4NNZ5B4awH6SCm3NJSO2B++ImCt22qLh1SqIpnqE3qbrA7kGwAqA9FtsoSyf23gowIQKBgQDE40rYSrMa3RfkBqAiDB8YVRf3hhgtt4vpqzyJojep5DaYsKeept7KJerOJw81/5bkuPGB3d+ZXkGBbpBUmN1BM0evxPcPQsivjCFqIpF1jhstswMRLVh8P9gXxoziIIab9dUb8ySd2juV3MEKfKnbuP2Wu88FhPeGLy13kklWAQKBgQDQO0xhJ4jY/m2BYDRZQ3CAbjwC5Q/OcUoIkU5wtiwS9mPdxEe6y9uk1VyhwUDmfwM6e9Bc0JCSq47FoCmTsChylE+QZhOfFfMe/ksEBr3LsSNRfEaToYFQC1g2aRVVs1pBa9ytIHwDr95sAX2XF7Yd/w679m5qH87xzxP6Vd6L3A==";
        System.out.println("待签名：" + sb.toString());
        System.out.println("签名后: " + SignUtil.sign(pk, sb.toString()));
    }

}
