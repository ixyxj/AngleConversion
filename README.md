# AngleConversion
:boom: 角度转换工具，六十进制度分秒

[![](https://jitpack.io/v/ixyxj/AngleConversion.svg)](https://jitpack.io/#ixyxj/AngleConversion)

### Gradle引用
```
step 1:
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

step 2:
dependencies {
    implementation 'com.github.ixyxj:AngleConversion:1.0.1'
}
```


### 角度转六十进制
```java
System.out.println(AngleUtil.degToHexadecimalStr("1.10020000"));
System.out.println(AngleUtil.degToHexadecimalStr("1.10220000"));
System.out.println(AngleUtil.degToHexadecimalStr("25.9999168", 1));
System.out.println(AngleUtil.degToHexadecimalStr("25.9999168", 2));
```

### 弧度转六十进制
```java
System.out.println(AngleUtil.radToHexadecimalStr(radians, 12));
```

### 数字度分秒转六十进制表示
```java
System.out.println(AngleUtil.parseToHexadecimalStr("25.5959999", 1));
System.out.println(AngleUtil.parseToHexadecimalStr("25.5959999", 2));
```

### 六十进制表示或者度分秒转角度或者弧度
```java
//double hexa = 12.01010111;
String hexa = "12°01′01.0111888877″";
double degrees = AngleUtil.hexadecimalToDegrees(String.valueOf(hexa));
double radians = AngleUtil.hexadecimalToRadians(String.valueOf(hexa));
```

### Java数字操作, 科学计数法转换
```java
System.out.println(NumberUtil.convertSci("4.99958333E7"));
```

### 格式化
```java
System.out.println(NumberUtil.format(00.00123, 10));
System.out.println(NumberUtil.format(1234.00123, 1));
```

### 判断数字
```java
System.out.println(NumberUtil.isNumber("001"));
System.out.println(NumberUtil.isNumber("-0.000220000"));
System.out.println(NumberUtil.isNumber("1."));
System.out.println(NumberUtil.isNumber("00.00"));
System.out.println(NumberUtil.isNumber("0.000000000"));
```
