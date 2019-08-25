package top.clearlight.question;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        String strNum = Long.toString(num);

        char[] chars = strNum.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = chars.length - 1; i >= 0; i -= 2) {
            sb.append(chars[i]);
        }
        System.out.println(sb);
    }
}
