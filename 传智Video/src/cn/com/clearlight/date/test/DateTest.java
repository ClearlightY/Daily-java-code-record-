package cn.com.clearlight.date.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * 计算两个日期之间间隔多少天.
 * 方法:1.将日期字符串转换为日期对象.
 * 2.算出两个日期的毫秒值
 * 3.将两个日期的毫秒值相减后转换为天数即可
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        String str_date1 = "2019-12-31";
        String str_date2 = "2019-6-19";
        test(str_date1, str_date2);
    }

    private static void test(String str_date1, String str_date2) throws ParseException {
        DateFormat dateFormat = DateFormat.getDateInstance();

        Date date1 = dateFormat.parse(str_date1);
        Date date2 = dateFormat.parse(str_date2);

        Long day = date1.getTime() - date2.getTime();

        System.out.println(date1.getTime());
        System.out.println(date2.getTime());
        System.out.println(day);

        System.out.println(day / 1000 / 60 / 60 / 24);
    }
}
