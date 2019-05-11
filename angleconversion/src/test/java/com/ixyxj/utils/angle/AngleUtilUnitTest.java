package com.ixyxj.utils.angle;

import org.junit.Test;

/**
 * created by ixyxj on 2019/4/11 22:24
 */
public class AngleUtilUnitTest {

    @Test
    public void testConversion() throws AngleConversionException {
        //double hexa = 12.01010111;
        String hexa = "12°01′01.0111888877″";
        double degrees = AngleUtil.hexadecimalToDegrees(String.valueOf(hexa));
        double radians = AngleUtil.hexadecimalToRadians(String.valueOf(hexa));
        System.out.println(degrees);
        System.out.println(radians);
        System.out.println(AngleUtil.degToHexadecimalStr(degrees));
        System.out.println(AngleUtil.radToHexadecimalStr(radians));
        System.out.println(AngleUtil.degToHexadecimalStr(degrees, 12));
        System.out.println(AngleUtil.radToHexadecimalStr(radians, 12));
    }

    @Test
    public void testFormat() throws AngleConversionException {
        System.out.println(AngleUtil.degToHexadecimalStr("0."));
        System.out.println(AngleUtil.degToHexadecimalStr("0.0"));
        System.out.println(AngleUtil.degToHexadecimalStr("0.00"));
        System.out.println(AngleUtil.degToHexadecimalStr("0.000"));
        System.out.println(AngleUtil.degToHexadecimalStr("0.0000"));
        System.out.println(AngleUtil.degToHexadecimalStr("0.00000"));
        System.out.println(AngleUtil.degToHexadecimalStr("0.000000"));
        System.out.println(AngleUtil.degToHexadecimalStr("0.0000000"));
        System.out.println(AngleUtil.degToHexadecimalStr("0.00000000"));
        System.out.println(AngleUtil.degToHexadecimalStr("0.000000000"));
        System.out.println(AngleUtil.degToHexadecimalStr("0.0000000000"));
        System.out.println(AngleUtil.degToHexadecimalStr("1.100020000"));
        System.out.println(AngleUtil.degToHexadecimalStr("1.10020000"));
        System.out.println(AngleUtil.degToHexadecimalStr("1.10220000"));
        System.out.println(AngleUtil.degToHexadecimalStr("25.9999168", 1));
        System.out.println(AngleUtil.degToHexadecimalStr("25.9999168", 2));
        System.out.println(AngleUtil.degToHexadecimalStr("25.9999168", 4));
        System.out.println(AngleUtil.degToHexadecimalStr("25.9999168", 5));
        System.out.println(AngleUtil.degToHexadecimalStr("25.9999168", 6));
        System.out.println(AngleUtil.degToHexadecimalStr("25.9999168", 7));
        System.out.println(AngleUtil.degToHexadecimalStr("25.9999168", 10));
    }

    @Test
    public void testStrFormat() throws AngleConversionException {
        System.out.println(AngleUtil.parseToHexadecimalStr( "12.121212121"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.0"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.00"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.000"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.0000"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.00000"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.000000"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.0000000"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.00000000"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.000000000"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.0000000000"));
        System.out.println(AngleUtil.parseToHexadecimalStr("25.5959999", 1));
        System.out.println(AngleUtil.parseToHexadecimalStr("25.5959999", 2));
        System.out.println(AngleUtil.parseToHexadecimalStr("25.5959999", 3));
        System.out.println(AngleUtil.parseToHexadecimalStr("25.5959999", 4));
        System.out.println(AngleUtil.parseToHexadecimalStr("25.5959999", 5));
        System.out.println(AngleUtil.parseToHexadecimalStr("25.5959999", 6));
        System.out.println(AngleUtil.parseToHexadecimalStr("25.5959999", 7));
        System.out.println(AngleUtil.parseToHexadecimalStr("25.5959999", 8));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.1212120", 0));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.1212120", 1));
        System.out.println(AngleUtil.parseToHexadecimalStr("25.1212120", 2));
        System.out.println(AngleUtil.parseToHexadecimalStr("25.1212120", 3));
        System.out.println(AngleUtil.parseToHexadecimalStr("25.1212120", 4));
        System.out.println(AngleUtil.parseToHexadecimalStr("25.1212120", 5));
        System.out.println(AngleUtil.parseToHexadecimalStr("25.1212120", 6));
        System.out.println(AngleUtil.parseToHexadecimalStr("25.1212120", 7));
        System.out.println(AngleUtil.parseToHexadecimalStr("25.1212120", 8));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.1"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.01"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.001"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.0001"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.00001"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.000001"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.0000001"));
        System.out.println(AngleUtil.parseToHexadecimalStr("0.00000001"));
    }
}
