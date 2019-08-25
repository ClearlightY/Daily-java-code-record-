package top.clearlight.question;

import java.util.Arrays;

public class ValueTran {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        changeArrValue(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void changeArrValue(int[] arr) {
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 0;
    }
}
