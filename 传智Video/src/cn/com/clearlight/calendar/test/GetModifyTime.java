package cn.com.clearlight.calendar.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * 将毫秒格式化日期
 */
public class GetModifyTime {
    public static void main(String[] args) {
        Date date = new Date();
        long mtime = date.getTime();

        // 获取Calendar对象
        Calendar cal = Calendar.getInstance();
        // 设置时间为 millis
        cal.setTimeInMillis(mtime);
        // 获取格式化对象,它会按照"yyyy-MM-dd HH:mm:ss"格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(cal.getTime()));
    }
}
