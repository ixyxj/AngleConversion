package com.ixyxj.utils.angle;

import android.support.annotation.NonNull;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created by ixyxj on 2019/4/11 22:17
 * 数字转换工具类
 */

public class NumberUtil {

    /**
     * 获取精度
     *
     * @param angdeg
     * @return
     */
    public static int getAccuracy(double angdeg) throws AngleConverException {
        return getAccuracy(String.valueOf(angdeg));
    }

    /**
     * 获取小数部分
     *
     * @param d
     * @return
     */
    public static double getDecimal(String d) throws AngleConverException {
        if (!isNumber(d)) {
            throw new AngleConverException("it is not a number");
        }
        int index = d.lastIndexOf(".");
        return index > 0 ? convertTodouble(d.substring(Math.min(index, d.length())), 0) : 0;
    }

    /**
     * 获取精度
     *
     * @param angdegStr
     * @return
     */
    public static int getAccuracy(String angdegStr) throws AngleConverException {
        if (!isNumber(angdegStr)) {
            throw new AngleConverException("it is not a number");
        }
        int index = angdegStr.lastIndexOf(".");
        return index > 0 ? angdegStr.substring(Math.min(index + 1, angdegStr.length())).length() : 0;
    }

    /**
     * 设置数字格式化
     *
     * @param num
     * @param decimal
     * @return
     */
    public static String format(double num, int decimal) {
        String value = String.valueOf(num);
        return format(value, decimal);
    }

    public static double formatDoudble(double num, int decimal) {
        String value = String.valueOf(num);
        return convertTodouble(format(value, decimal), 0);
    }

    /**
     * 设置数字格式化
     *
     * @param value
     * @param decimal
     * @return
     */
    @NonNull
    public static String format(String value, int decimal) {
        if (isInteger(value)) return "";
        int index = value.indexOf(".");
        String integer = value.substring(0, index == -1 ? 0 : index);
        int length = integer.length();
        DecimalFormat df = new DecimalFormat();
        StringBuilder pattern = new StringBuilder();
        //整数位为零的数就进行补零
        if (convertTodouble(integer, 0) == 0) {
            pattern.append("0");
        } else {
            //整数
            for (int i = 0; i < length; i++) {
                pattern.append("#");
            }
        }
        //小数
        if (decimal <= 0) df.applyPattern(pattern.toString());
        else {
            pattern.append(".");
            for (int i = 0; i < decimal; i++) {
                pattern.append("0");
            }
            df.applyLocalizedPattern(pattern.toString());
        }
        return df.format(convertToDouble(value));
    }

    /**
     * 判断是否是整数
     *
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^(-)?[0-9]*?$");
        return pattern.matcher(str).matches();
    }

    /**
     * 判断是否数字
     *
     * @param content
     * @return
     */
    public static boolean isNumber(String content) {
        return match("^(-)?[0-9]+(\\.[0-9]*)?$", content);
    }

    private static boolean match(String regex, String str) {
        if (str == null || str.isEmpty()) return false;
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }


    /**
     * 单个字符判断
     *
     * @param c
     * @return
     */
    public static boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    /**
     * 暂时不用
     *
     * @param str
     * @return
     */
    public static boolean isNumber2(String str) {
        int size = str.length();
        for (int i = 0; i < size; i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static int convertToint(String intStr, int defValue) {
        try {
            return Integer.parseInt(intStr);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        return defValue;
    }

    public static long convertTolong(String longStr, long defValue) {
        try {
            return Long.parseLong(longStr);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        return defValue;
    }

    public static float convertTofloat(String fStr, float defValue) {
        try {
            return Float.parseFloat(fStr);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        return defValue;
    }

    public static double convertTodouble(String dStr, double defValue) {
        try {
            return Double.parseDouble(dStr);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        return defValue;
    }


    public static Integer convertToInteger(String intStr) {
        try {
            return Integer.parseInt(intStr);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        return null;
    }

    public static Long convertToLong(String longStr) {
        try {
            return Long.parseLong(longStr);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        return null;
    }

    public static Float convertToFloat(String fStr) {
        try {
            return Float.parseFloat(fStr);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        return null;
    }

    public static Double convertToDouble(String dStr) {
        try {
            return Double.parseDouble(dStr);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        return null;
    }

}