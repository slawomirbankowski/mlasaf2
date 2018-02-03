package com.mlasaf.utils;

public class MlUtils {

    public static String getHostName() {
        try {
            return java.net.Inet4Address.getLocalHost().getHostName();
        } catch (Exception ex) {
            return "";
        }
    }
    public static String getHostAddress() {
        try {
            return java.net.Inet4Address.getLocalHost().getHostAddress();
        } catch (Exception ex) {
            return "";
        }
    }

}
