package cn.com.clearlight.calendar.test;

import java.util.Calendar;
import java.util.Scanner;

/**
 * 需求 : 输入指定年份,打印2月的天数
 */
public class CalendarTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();


        showDaysToFeb(year);
    }

    private static void showDaysToFeb(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, 2, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(year + "年二月一共有" + day + "天");
    }
}
