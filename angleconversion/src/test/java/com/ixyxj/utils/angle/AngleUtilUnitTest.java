package com.ixyxj.utils.angle;

import org.junit.Test;

/**
 * created by ixyxj on 2019/4/11 22:24
 */
public class AngleUtilUnitTest {

    @Test
    public void testFormat() throws AngleConverException {
        System.out.println(AngleUtil.degToSixagesimalStr("0."));
        System.out.println(AngleUtil.degToSixagesimalStr("0.0"));
        System.out.println(AngleUtil.degToSixagesimalStr("0.00"));
        System.out.println(AngleUtil.degToSixagesimalStr("0.000"));
        System.out.println(AngleUtil.degToSixagesimalStr("0.0000"));
        System.out.println(AngleUtil.degToSixagesimalStr("0.00000"));
        System.out.println(AngleUtil.degToSixagesimalStr("0.000000"));
        System.out.println(AngleUtil.degToSixagesimalStr("0.0000000"));
        System.out.println(AngleUtil.degToSixagesimalStr("0.00000000"));
        System.out.println(AngleUtil.degToSixagesimalStr("0.000000000"));
        System.out.println(AngleUtil.degToSixagesimalStr("0.0000000000"));
        System.out.println(AngleUtil.degToSixagesimalStr("-1.100020000"));
        System.out.println(AngleUtil.degToSixagesimalStr("-0.10020000"));
        System.out.println(AngleUtil.degToSixagesimalStr("-0.000220000"));
        System.out.println(AngleUtil.degToSixagesimalStr("1.100020000"));
        System.out.println(AngleUtil.degToSixagesimalStr("1.10020000"));
        System.out.println(AngleUtil.degToSixagesimalStr("1.10220000"));
        System.out.println(AngleUtil.degToSixagesimalStr("25.9999168", 1));
        System.out.println(AngleUtil.degToSixagesimalStr("25.9999168", 2));
        System.out.println(AngleUtil.degToSixagesimalStr("25.9999168", 4));
        System.out.println(AngleUtil.degToSixagesimalStr("25.9999168", 5));
        System.out.println(AngleUtil.degToSixagesimalStr("25.9999168", 6));
        System.out.println(AngleUtil.degToSixagesimalStr("25.9999168", 7));
        System.out.println(AngleUtil.degToSixagesimalStr("25.9999168", 10));
    }

    @Test
    public void testStrFormt() throws AngleConverException {
        System.out.println(AngleUtil.degToSixagesimalStr(12.121212121));
        System.out.println(AngleUtil.parseToSixagesimalStr(12.121212121 + ""));
//       System.out.println(AngleUtil.parseToSixagesimalStr("0."));
//       System.out.println(AngleUtil.parseToSixagesimalStr("0.0"));
//       System.out.println(AngleUtil.parseToSixagesimalStr("0.00"));
//       System.out.println(AngleUtil.parseToSixagesimalStr("0.000"));
//       System.out.println(AngleUtil.parseToSixagesimalStr("0.0000"));
//       System.out.println(AngleUtil.parseToSixagesimalStr("0.00000"));
//       System.out.println(AngleUtil.parseToSixagesimalStr("0.000000"));
//       System.out.println(AngleUtil.parseToSixagesimalStr("0.0000000"));
//       System.out.println(AngleUtil.parseToSixagesimalStr("0.00000000"));
//       System.out.println(AngleUtil.parseToSixagesimalStr("0.000000000"));
//       System.out.println(AngleUtil.parseToSixagesimalStr("0.0000000000"));
//        System.out.println(AngleUtil.parseToSixagesimalStr("25.5959999", 1));
//        System.out.println(AngleUtil.parseToSixagesimalStr("25.5959999", 2));
//        System.out.println(AngleUtil.parseToSixagesimalStr("25.5959999", 3));
//        System.out.println(AngleUtil.parseToSixagesimalStr("25.5959999", 4));
//        System.out.println(AngleUtil.parseToSixagesimalStr("25.5959999", 5));
//        System.out.println(AngleUtil.parseToSixagesimalStr("25.5959999", 6));
//        System.out.println(AngleUtil.parseToSixagesimalStr("25.5959999", 7));
//        System.out.println(AngleUtil.parseToSixagesimalStr("25.5959999", 8));
        System.out.println(AngleUtil.parseToSixagesimalStr("0.1212120", 0));
        System.out.println(AngleUtil.parseToSixagesimalStr("0.1212120", 1));
        System.out.println(AngleUtil.parseToSixagesimalStr("25.1212120", 2));
        System.out.println(AngleUtil.parseToSixagesimalStr("25.1212120", 3));
        System.out.println(AngleUtil.parseToSixagesimalStr("25.1212120", 4));
        System.out.println(AngleUtil.parseToSixagesimalStr("25.1212120", 5));
        System.out.println(AngleUtil.parseToSixagesimalStr("25.1212120", 6));
        System.out.println(AngleUtil.parseToSixagesimalStr("25.1212120", 7));
        System.out.println(AngleUtil.parseToSixagesimalStr("25.1212120", 8));
    }
}
