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
    /**
     * 返回double形式的度分秒格式
     *
     * @param angle
     * @return
     */
    public static double getDoubleAngle(Angle angle) {
        String strAngle = angle.getDegree() + "." + (angle.getMinute() < 10 ? ("0" + angle.getMinute()) : angle.getMinute())
                + String.valueOf(angle.getSecond() < 10 ? ("0" + angle.getSecond()) : angle.getSecond()).replace(".", "");
        return Double.valueOf(strAngle);
    }

    /**
     * 从弧度直接转六十进制显示
     *
     * @param angrad
     * @param accuracy 精度
     * @return
     */
    public static String radToSixagesimalStr(double angrad, int accuracy) throws AngleConverException {
        Angle a = toAngle(toDegree(angrad), accuracy);
        return toSixagesimalStr(a);
    }

    public static String radToSixagesimalStr(double angrad) throws AngleConverException {
        Angle a = toAngle(toDegree(angrad));
        return toSixagesimalStr(a);
    }

    /**
     * 角度字符转六十进制显示
     *
     * @param angdeg
     * @return
     */
    public static String degToSixagesimalStr(double angdeg) throws AngleConverException {
        return degToSixagesimalStr(angdeg, -1);
    }

    public static String degToSixagesimalStr(double angdeg, int accuracy) throws AngleConverException {
        Angle a = toAngle(angdeg, accuracy);
        return toSixagesimalStr(a);
    }

    /**
     * 角度字符转六十进制显示
     *
     * @param angdeg
     * @return
     */
    public static String degToSixagesimalStr(String angdeg) throws AngleConverException {
        return degToSixagesimalStr(angdeg, -1);
    }

    public static String degToSixagesimalStr(String angdeg, int accuracy) throws AngleConverException {
        Angle a = toAngle(angdeg, accuracy);
        return toSixagesimalStr(a);
    }

    /**
     * 解析的角度字符串
     *
     * @param angdegStr
     * @return
     */
    public static String parseToSixagesimalStr(String angdegStr) throws AngleConverException {
        return parseToSixagesimalStr(angdegStr, -1);
    }

    public static String parseToSixagesimalStr(String angdegStr, int accuracy) throws AngleConverException {
        Angle a = strToAngle(angdegStr, accuracy);
        return toSixagesimalStr(a);
    }

    /**
     * 获取去度分秒的角度
     *
     * @param value
     * @return
     */
    public static String getRealText(String value) {
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
     * 从Angle获取六十进制的显示效果
     *
     * @param angle
     * @return
     */
    public static String toSixagesimalStr(Angle angle) throws AngleConverException {
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
                strSecond = new StringBuilder(strSecond.substring(0, strSecond.length() - 2));
                break;
            default://0°00′00.0″ => 3
                int real = accuracy - 2;
                int secondAccuracy = NumberUtil.getAccuracy(strSecond.toString());
                //秒真实进度
                if (secondAccuracy > real) {
                    //用real截取
                    String s = NumberUtil.format(strSecond.toString(), real);
                    strSecond = new StringBuilder(s);
                } else {
                    int num = real - secondAccuracy;
                    for (int i = 0; i < num; i++) {
                        strSecond.append(0);
                    }
                }
                break;
        }
        return String.format(Locale.getDefault(), format, angle.getDegree()
                , angle.getMinute(), strSecond.toString());
    }

    private static double checkPrecision(Angle angle) {
        int accuracy = angle.getAccuracy();
        //计算秒的精度
        if (accuracy >= 2) {
            double second = NumberUtil.formatDoudble(angle.getSecond(), accuracy - 2);
            if (second >= 60) {
                //进一
                angle.addOne();
                // 防止format再次进一
                second = NumberUtil.convertTodouble(String.valueOf(angle.getSecond()).substring(0, accuracy), 0);
            }
            return second;
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
    public static Angle toAngle(double angdeg, int accuracy) throws AngleConverException {
        int degree = (int) angdeg;
        double minuteDouble = (angdeg - degree) * 60d;
        int minute = (int) minuteDouble;
        double second = (minuteDouble - minute) * 60d;
        return new Angle(degree, minute, second, accuracy == -1 ? NumberUtil.getAccuracy(angdeg) : accuracy);
    }

    /**
     * 角度转度分秒
     *
     * @param angdeg
     * @return
     */
    public static Angle toAngle(double angdeg) throws AngleConverException {
        return toAngle(angdeg, -1);
    }

    /**
     * 获取angle
     *
     * @param angdegStr
     * @return
     */
    public static Angle toAngle(String angdegStr, int accuracy) throws AngleConverException {
        if (!NumberUtil.isNumber(angdegStr)) return new Angle();
        return toAngle(NumberUtil.convertTodouble(angdegStr, -1), accuracy);
    }

    public static Angle toAngle(String angdegStr) throws AngleConverException {
        return toAngle(NumberUtil.convertTodouble(angdegStr, -1));
    }

    /**
     * 格式ddd.mmssssss
     *
     * @param angdegStr
     * @return
     */
    public static Angle strToAngle(String angdegStr) throws AngleConverException {
        return strToAngle(angdegStr, -1);
    }

    /**
     * 格式ddd.mmssssss
     *
     * @param angdegStr
     * @return
     */
    public static Angle strToAngle(String angdegStr, int accuracy) throws AngleConverException {
        Angle a = new Angle();
        if (angdegStr == null || angdegStr.isEmpty()) return a;
        int index = angdegStr.lastIndexOf(".");
        //真实精度
        int realAccuracy = 0;
        if (index > 0) {//有小数
            a.setDegree(Integer.valueOf(angdegStr.substring(0, index)));
            realAccuracy++;
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
                if (secondStr.length() == 2 && !(Integer.valueOf(secondStr) < 60)) {
                    realAccuracy++;
                    a.setSecond(Double.valueOf(secondStr));
                } else if (Integer.valueOf(secondStr.substring(0, Math.min(2, secondStr.length()))) > 60) {
                    //12.5959999
                    double second = Double.valueOf(secondStr) / Math.pow(10, secondStr.length() - 1);
                    realAccuracy = NumberUtil.getAccuracy(second) + 1;
                    a.setSecond(second);
                } else {
                    double second = Double.valueOf(secondStr) / Math.pow(10, secondStr.length() - Math.min(2, secondStr.length()));
                    realAccuracy += NumberUtil.getAccuracy(second);
                    a.setSecond(second);
                }
            }
        } else {
            a.setDegree(Integer.valueOf(angdegStr));
        }
        a.setAccuracy(accuracy == -1 ? realAccuracy : accuracy);
        return a;
    }
}
