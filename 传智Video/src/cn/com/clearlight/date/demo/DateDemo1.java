package cn.com.clearlight.date.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将日期格式字符串转换为日期对象
 * 使用的是DateFormat类中的parse()方法
 */
public class DateDemo1 {
    public static void main(String[] args) throws ParseException {
        method_1();
        method_2();
        method_3();
    }

    private static void method_3() throws ParseException {
        String str_date = "2019--12--15";

        DateFormat dateFormat = new SimpleDateFormat("yyyy--MM--dd");

        Date date = dateFormat.parse(str_date);

        System.out.println(date);
    }

    private static void method_2() throws ParseException {
        String str_date = "2019-12-15";

        DateFormat dateFormat = DateFormat.getDateInstance();

        Date date = dateFormat.parse(str_date);

        System.out.println(date);
    }

    public static void method_1() throws ParseException {
        String str_date = "2019年12月15日";

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);

        Date date = dateFormat.parse(str_date);

        System.out.println(date);
    }
}
