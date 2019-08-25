package cn.com.clearlight.date.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将日期对象转换为日期格式的字符串
 */
public class DateDemo2 {
    public static void main(String[] args) {
        Date date = new Date();

        //获取日期格式对象.具有默认的风格.FULL LONG等可以指定风格
        // DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL); // 2019年6月19日 星期三
        // DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT); // 19-6-19
        // DateFormat dateFormat = DateFormat.getDateInstance(); // 2019-6-19
        // DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG); // 2019年6月19日 下午02时55分47秒
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy--MM--dd"); // 2019--06--19

        String str_date = dateFormat.format(date);

        System.out.println(str_date);

    }
}
