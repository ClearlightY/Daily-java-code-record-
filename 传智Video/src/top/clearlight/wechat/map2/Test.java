package top.clearlight.wechat.map2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] array = new int[a];
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(line[i]);
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
