package com.kari3600.me.utils;

public class MathUtil {
    public static double round(double value, double precision) {
        return Math.round(value / precision) * precision;
    }

    public static int round(double value, int precision) {
        return (int) Math.round(value / precision) * precision;
    }
}
