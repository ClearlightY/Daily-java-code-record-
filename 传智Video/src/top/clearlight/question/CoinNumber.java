package top.clearlight.question;

import java.util.Scanner;

/**
 * 面试题
 * 明的抽屉有n个游戏币，总值m，游戏币的设置有1分的，2分的，5分的，10分的，在明所拥有的游戏币中有些值的游戏币可能没有，求共有多少种可能的游戏币组合式？
 * 输：输两个数n（游戏币的个数），m（总值）。
 * 输出：请输出可能的组合式数；
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/4/1 21:48
 */
public class CoinNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int total = sc.nextInt();
        int combin_num = getCombinationNum(num, total);
        System.out.println(combin_num);
    }

    public static int getCombinationNum(int num, int total) {
        int combin_num = 0;
        for (int one_num = 0; one_num <= num; one_num++) {
            for (int two_num = 0; two_num <= num; two_num++) {
                for (int five_num = 0; five_num <= num; five_num++) {
                    for (int ten_num = 0; ten_num < num; ten_num++) {
                        if (one_num + two_num + five_num + ten_num == num && one_num + 2 * two_num + 5 * five_num + 10 * ten_num == total) {
                            if (one_num < 0 || two_num < 0 || five_num < 0 || (num - one_num - two_num - five_num) < 0) {
                                continue;
                            }
                            System.out.println(one_num + " " + two_num + " " + five_num + " " + (num - (one_num + two_num + five_num)));
                            combin_num++;
                        }
                    }
                }
            }
        }
        return combin_num;
    }
}
