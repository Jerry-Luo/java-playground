package com.jerry.system;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
/**
 * Filename      IpUtil
 * Description   IP 工具类
 * Copyright     Copyright (c) 2016-2022 All Rights Reserved.
 * Company       fintechzh.com Inc.
 * @author       罗建伟
 * @date         2018-12-11 23:58
 * @version      1.0
 */
public class IpUtil {

    private static final String IP_REGEX = "(\\d{1,3}\\.){3}\\d{1,3}";

    public static void main(String[] args) {
        System.out.println(IpUtil.getMac());
        System.out.println(IpUtil.getLocalIP());
    }

    private IpUtil() {
    }

    public static String getLocalIP() {
        InetAddress ip = null;
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                ip = findIp (netInterfaces.nextElement());
                if (ip != null) break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != ip) {
            return ip.getHostAddress();
        }
        return null;
    }

    private static InetAddress findIp (NetworkInterface ni) {
        Enumeration<InetAddress> ips = ni.getInetAddresses();
        while (ips.hasMoreElements()) {
            InetAddress ip = ips.nextElement();
            if (!ip.isLoopbackAddress() && ip.getHostAddress().matches(IP_REGEX)) {
                return ip;
            }
        }
        return null;
    }

    public static List<String> getLocalIPS() {
        InetAddress ip;
        List<String> ipList = new ArrayList<>();
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    ip = ips.nextElement();
                    if (!ip.isLoopbackAddress() && ip.getHostAddress().matches(IP_REGEX)) {
                        ipList.add(ip.getHostAddress());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ipList;
    }

    public static String getMac() {
        String mac = "";
        InetAddress ip = null;
        NetworkInterface ni = null;
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                ni = netInterfaces.nextElement();
                ip = findIp(ni);
                if (ip != null) break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != ip) {
            try {
                mac = getMacFromBytes(ni.getHardwareAddress());
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
        return mac;
    }

    public static List<String> getMacs() {
        InetAddress ip;
        NetworkInterface ni;
        List<String> macList = new ArrayList<>();
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                ni = netInterfaces.nextElement();
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    ip = ips.nextElement();
                    if (!ip.isLoopbackAddress() // 非127.0.0.1
                        && ip.getHostAddress().matches(IP_REGEX)) {
                        macList.add(getMacFromBytes(ni.getHardwareAddress()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return macList;
    }

    private static String getMacFromBytes(byte[] bytes) {
        StringBuilder mac = new StringBuilder();
        byte currentByte;
        for (int i = 0; i < bytes.length; i++) {
            if (i != 0) {
                mac.append("-");
            }
            currentByte = (byte) ((bytes[i] & 240) >> 4);
            mac.append(Integer.toHexString(currentByte));
            currentByte = (byte) (bytes[i] & 15);
            mac.append(Integer.toHexString(currentByte));
        }
        return mac.toString().toUpperCase();
    }
}