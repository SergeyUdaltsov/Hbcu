package com.hbcu.utils;

public class StringUtils {

    public StringUtils() {
    }

    public static boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }
}