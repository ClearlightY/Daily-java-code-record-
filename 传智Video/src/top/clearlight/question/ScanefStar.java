package top.clearlight.question;

import java.util.Scanner;

public class ScanefStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();

        for (int i = 1; i <= line; i++) {
            int j = 1;
            while (j <= 2 * i - 1) {
                System.out.print("*");
                j++;
            }
            System.out.println();
        }
    }
}
