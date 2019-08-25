package cn.com.clearlight.calendar.demo;

import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(2011, 3, 20); // 指定一个日期

        calendar.add(Calendar.YEAR, 2); // 年份向后偏移2年

        showDate(calendar);
    }

    private static void showDate(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String week = getWeek(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(year + "年" + month + "月" + day + "日" + week);
    }

    private static String getWeek(int i) {
        String[] weeks = {"", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        return weeks[i];
    }
}
