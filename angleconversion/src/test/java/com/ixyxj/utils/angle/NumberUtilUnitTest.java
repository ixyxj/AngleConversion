package com.ixyxj.utils.angle;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * created by ixyxj on 2019/4/1 21:18
 */
public class NumberUtilUnitTest {

    @Test
    public void testConvert() {
        System.out.println(NumberUtil.convertSci("4.99958333E7"));
        System.out.println(new BigDecimal("4.99958333E7").toString());
        System.out.println(new BigDecimal("4.99958333E7").toEngineeringString());
        System.out.println(new BigDecimal("4.99958333E7").toPlainString());
    }

    @Test
    public void testFormat() {
        System.out.println(NumberUtil.format(00.00123, 10));
        System.out.println(NumberUtil.format(1234.00123, 1));
        System.out.println(NumberUtil.format(0.00123, 2));
        System.out.println(NumberUtil.format(1.00123, 3));
        System.out.println(NumberUtil.format(1.00123, 4));
        System.out.println(NumberUtil.format(1.00123, 5));
        System.out.println(NumberUtil.format(-1.00123, 6));
    }

    @Test
    public void testNumber() {
        System.out.println(Math.ceil(1.00000000011));
        System.out.println(Math.floor(1.00000000011));
        System.out.println(Math.floor(1.09900000099));
        System.out.println(NumberUtil.isNumber("001"));
        System.out.println(NumberUtil.isNumber("-0.000220000"));
        System.out.println(NumberUtil.isNumber("1."));
        System.out.println(NumberUtil.isNumber("00.00"));
        System.out.println(NumberUtil.isNumber("0.000000000"));


        System.out.println(NumberUtil.isInteger("-00100000"));
        System.out.println(NumberUtil.isInteger("001"));
        System.out.println(NumberUtil.isInteger("00100"));
        System.out.println(NumberUtil.isInteger("0.000000"));
        System.out.println(NumberUtil.isInteger("00.000000"));
    }

    @Test
    public void testStr2Angle() throws AngleConverException {
        System.out.println(AngleUtil.strToAngle("1.0100000000001").getDegree());
        System.out.println(AngleUtil.strToAngle("1.1000000000001").getMinute());
        System.out.println(AngleUtil.strToAngle("1.0100000000001").getSecond());
        System.out.println(AngleUtil.strToAngle("1.0100000000001").getAccuracy());
    }
}
