package com.ixyxj.utils.angle;

import java.util.Locale;

/**
 * created by ixyxj on 2019/4/11 22:09
 * 角度转换工具：
 * 弧度转角度
 * 角度转六十进制
 * 角度字符串转六十进制 等
 */
public class AngleUtil {
    public static double hexadecimalToDegrees(String hexadecimalStr) throws AngleConversionException {
        String hexaStr = removeHexadecimalStr(hexadecimalStr);
        return toDegree(strToAngle(hexaStr));
    }

    /**
     * 六十进制转角度
     *
     * @param hexadecimalStr
     * @param accuracy
     * @return
     */
    public static double hexadecimalToDegrees(String hexadecimalStr, int accuracy) throws AngleConversionException {
        String hexaStr = removeHexadecimalStr(hexadecimalStr);
        return toDegree(strToAngle(hexaStr, accuracy));
    }

    public static double hexadecimalToRadians(String hexadecimalStr) throws AngleConversionException {
        return toRadians(hexadecimalToDegrees(hexadecimalStr));
    }

    /**
     * 六十进制转弧度
     *
     * @param hexadecimalStr
     * @param accuracy
     * @return
     * @throws AngleConversionException
     */
    public static double hexadecimalToRadians(String hexadecimalStr, int accuracy) throws AngleConversionException {
        return toRadians(hexadecimalToDegrees(hexadecimalStr, accuracy));
    }

    /**
     * 返回double形式的度分秒格式
     *
     * @param angle
     * @return
     */
    public static double getHexadecimalDouble(Angle angle) {
        String strAngle = angle.getDegree() + "." + (angle.getMinute() < 10 ? ("0" + angle.getMinute()) : angle.getMinute())
                + String.valueOf(angle.getSecond() < 10 ? ("0" + angle.getSecond()) : angle.getSecond()).replace(".", "");
        return Double.valueOf(strAngle);
    }

    /**
     * 获取去度分秒的角度
     *
     * @param value
     * @return
     */
    public static String removeHexadecimalStr(String value) {
        if (!value.contains("°")) return value;
        int degreeIndex = value.indexOf("°");
        if (degreeIndex < 0)
            return value;
        Angle angle = new Angle();
        if (degreeIndex > 0) {
            angle.setDegree(Integer.valueOf(value.substring(0, degreeIndex)));
        }
        int minuteIndex = value.indexOf("′");
        if (minuteIndex > 0) {
            angle.setMinute(Integer.valueOf(value.substring(degreeIndex + 1, minuteIndex)));
        }
        int secondIndex = value.indexOf("″");
        if (secondIndex > 0) {
            angle.setSecond(Double.valueOf(value.substring(minuteIndex + 1, secondIndex)));
        }
        return angle.getDegree() + "." + (angle.getMinute() < 10 ? "0" + angle.getMinute() : angle.getMinute()) + String.valueOf(angle.getSecond() < 10 ? "0" + angle.getSecond() : angle.getSecond()).replace(".", "");
    }

    /**
     * 从弧度直接转六十进制显示
     *
     * @param angrad
     * @param accuracy 精度
     * @return
     */
    public static String radToHexadecimalStr(double angrad, int accuracy) throws AngleConversionException {
        Angle a = toAngle(toDegree(angrad), accuracy);
        return toHexadecimalStr(a);
    }

    public static String radToHexadecimalStr(double angrad) throws AngleConversionException {
        Angle a = toAngle(toDegree(angrad));
        return toHexadecimalStr(a);
    }

    /**
     * 角度字符转六十进制显示
     *
     * @param angdeg
     * @return
     */
    public static String degToHexadecimalStr(double angdeg) throws AngleConversionException {
        return degToHexadecimalStr(angdeg, -1);
    }

    public static String degToHexadecimalStr(double angdeg, int accuracy) throws AngleConversionException {
        Angle a = toAngle(angdeg, accuracy);
        return toHexadecimalStr(a);
    }

    /**
     * 角度字符转六十进制显示
     *
     * @param angdeg
     * @return
     */
    public static String degToHexadecimalStr(String angdeg) throws AngleConversionException {
        return degToHexadecimalStr(angdeg, -1);
    }

    public static String degToHexadecimalStr(String angdeg, int accuracy) throws AngleConversionException {
        Angle a = toAngle(angdeg, accuracy);
        return toHexadecimalStr(a);
    }

    /**
     * 解析的角度字符串
     *
     * @param angdegStr
     * @return
     */
    public static String parseToHexadecimalStr(String angdegStr) throws AngleConversionException {
        return parseToHexadecimalStr(angdegStr, -1);
    }

    public static String parseToHexadecimalStr(String angdegStr, int accuracy) throws AngleConversionException {
        Angle a = strToAngle(angdegStr, accuracy);
        return toHexadecimalStr(a);
    }


    /**
     * 从Angle获取六十进制的显示效果
     *
     * @param angle
     * @return
     */
    private static String toHexadecimalStr(Angle angle) throws AngleConversionException {
        if (angle == null) return null;
        int accuracy = angle.getAccuracy();
        double second = checkPrecision(angle);
        StringBuilder strSecond = new StringBuilder("" + second);
        if (second < 10) {
            strSecond.insert(0, "0");
        }
        String format = "%d°%02d′%s″";
        switch (accuracy) {
            case 0://0°
                format = "%d°";
                break;
            case 1://0°00′
                format = "%d°%02d′";
                break;
            case 2://0°00′00″
                strSecond = new StringBuilder(strSecond.substring(0, 2));
                break;
            default://0°00′00.0″ => 3
                int real = accuracy - 2;
                int secondAccuracy = NumberUtil.getAccuracy(strSecond.toString());
                //秒真实进度
                if (secondAccuracy > real) {
                    //用real截取
                    String s = NumberUtil.format(strSecond.toString(), real);
                    strSecond = new StringBuilder(s);
                    if (second < 10) {
                        strSecond.insert(0, "0");
                    }
                } else {
                    if (real > 2) real++;
                    int num = real - secondAccuracy - 1;
                    for (int i = 0; i < num; i++) {
                        strSecond.append(0);
                    }
                }
                break;
        }
        String symbol = angle.isNegative() ? "-" : "";
        return symbol + String.format(Locale.getDefault(), format, angle.getDegree()
                , angle.getMinute(), strSecond.toString());
    }

    private static double checkPrecision(Angle angle) {
        int accuracy = angle.getAccuracy();
        //计算秒的精度
        if (accuracy >= 2) {
            double second = NumberUtil.formatDouble(angle.getSecond(), accuracy - 2);
            if (second >= 60) {
                //进一
                angle.addOne();
            }
        }
        return angle.getSecond();
    }


    /**
     * 弧度转角度
     *
     * @param angrad
     * @return
     */
    public static double toDegree(double angrad) {
        return Math.toDegrees(angrad);
    }


    /**
     * 角度转弧度
     *
     * @param angdeg
     * @return
     */
    public static double toRadians(double angdeg) {
        return Math.toRadians(angdeg);
    }

    /**
     * 角度转度分秒
     *
     * @param angdeg 角度值，角度格式
     * @return
     */
    public static Angle toAngle(double angdeg, int accuracy) throws AngleConversionException {
        boolean isNegative = angdeg < 0;
        angdeg = Math.abs(angdeg);
        int degree = (int) angdeg;
        double minuteDouble = (angdeg - degree) * 60d;
        int minute = (int) minuteDouble;
        double second = (minuteDouble - minute) * 60d;
        return new Angle(degree, minute, second, accuracy == -1 ? NumberUtil.getAccuracy(angdeg) : accuracy, isNegative);
    }

    /**
     * 角度转度分秒
     *
     * @param angdeg
     * @return
     */
    public static Angle toAngle(double angdeg) throws AngleConversionException {
        return toAngle(angdeg, -1);
    }

    /**
     * 获取angle
     *
     * @param angdegStr
     * @return
     */
    public static Angle toAngle(String angdegStr, int accuracy) throws AngleConversionException {
        if (!NumberUtil.isNumber(angdegStr)) return new Angle();
        return toAngle(NumberUtil.convertTodouble(angdegStr, -1), accuracy);
    }

    public static Angle toAngle(String angdegStr) throws AngleConversionException {
        return toAngle(NumberUtil.convertTodouble(angdegStr, -1));
    }

    /**
     * 格式ddd.mmssssss
     *
     * @param angdegStr
     * @return
     */
    public static Angle strToAngle(String angdegStr) throws AngleConversionException {
        return strToAngle(angdegStr, -1);
    }

    /**
     * 格式ddd.mmssssss
     *
     * @param angdegStr
     * @return
     */
    public static Angle strToAngle(String angdegStr, int accuracy) throws AngleConversionException {
        Angle a = new Angle();
        if (angdegStr == null || angdegStr.isEmpty()) return a;
        int index = angdegStr.lastIndexOf(".");
        //真实精度
        int realAccuracy = 0;
        if (index > 0) {//有小数
            a.setDegree(Integer.valueOf(angdegStr.substring(0, index)));
            //分
            int end = Math.min(index + 1 + 2, angdegStr.length());
            //11.11111
            String minute = angdegStr.substring(index + 1, end);
            if (minute.length() == 1) minute += 0;
            if (!minute.isEmpty()) {
                a.setMinute(Integer.valueOf(minute));
                realAccuracy++;
            }
            if (end < angdegStr.length()) {
                String secondStr = angdegStr.substring(end);
                if (secondStr.length() == 1) secondStr += 0;
                double second = Double.valueOf(secondStr);
                if (secondStr.length() == 2 && !(Integer.valueOf(secondStr) < 60)) {
                    realAccuracy++;
                } else if (Integer.valueOf(secondStr.substring(0, Math.min(2, secondStr.length()))) > 60) {
                    //12.5959999
                    second = second / Math.pow(10, secondStr.length() - 2);
                    realAccuracy = NumberUtil.getAccuracy(second);
                } else {
                    if (second == 0) {
                        realAccuracy += secondStr.length() - 1;
                    } else {
                        realAccuracy++;
                        second = second / Math.pow(10, secondStr.length() - Math.min(2, secondStr.length()));
                        //排除整数情况
                        if ((int)second != second) realAccuracy += NumberUtil.getAccuracy(second);
                    }
                }
                a.setSecond(second);
            }
        } else {
            a.setDegree(Integer.valueOf(angdegStr));
        }
        a.setAccuracy(accuracy == -1 ? realAccuracy : accuracy);
        return a;
    }


    /**
     * 六十进制转角度
     *
     * @param angle
     * @return
     */
    public static double toDegree(Angle angle) {
        if (angle == null)
            return 0;
        return (angle.getSecond() / 3600d) + (angle.getMinute() / 60d) + angle.getDegree();
    }
}
