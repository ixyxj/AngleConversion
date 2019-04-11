package com.ixyxj.utils.angle;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * created by ixyxj on 2019/4/11 22:16
 * 角度单位，度分秒
 */
public class Angle implements Parcelable {
    private int degree;
    private int minute;
    private double second;
    private int accuracy;   //精度

    public Angle() {
    }

    public Angle(int degree, int minute,
                 double second, int accuracy) {
        this.degree = degree;
        this.minute = minute;
        this.second = second;
        this.accuracy = accuracy;
    }

    protected Angle(Parcel in) {
        degree = in.readInt();
        minute = in.readInt();
        second = in.readDouble();
        accuracy = in.readInt();
    }

    public static final Creator<Angle> CREATOR = new Creator<Angle>() {
        @Override
        public Angle createFromParcel(Parcel in) {
            return new Angle(in);
        }

        @Override
        public Angle[] newArray(int size) {
            return new Angle[size];
        }
    };

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getAccuracy() {
        return accuracy;
    }

    /**
     * 秒大于60, 分进一
     */
    public void addOne() {
        try {
            second = NumberUtil.getDecimal(second + "");
            minute += 1;
            if (minute >= 60) {
                minute = 0;
                degree += 1;
            }
        } catch (AngleConverException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        String secondStr = String.valueOf(second);
        int start = secondStr.indexOf(".");
        String intValue = secondStr.substring(0 , start);
        String shortValue = secondStr.substring(start + 1 , secondStr.length());
        return degree + "." + minute + intValue + shortValue;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(degree);
        dest.writeInt(minute);
        dest.writeDouble(second);
        dest.writeInt(accuracy);
    }
}