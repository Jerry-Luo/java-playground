package com.jerry.java.security.RSA;

public class RSATest {
    public static void main(String[] args) {
        RsaKeyPair keyPair = RSAKeyGenerator.generatorKey(256);
        System.out.println("n的值是:" + keyPair.getPublicKey().getN());
        System.out.println("公钥b:" + keyPair.getPublicKey().getB());
        System.out.println("私钥a:" + keyPair.getPrivateKey().getA());
    }
}
