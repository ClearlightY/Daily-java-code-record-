package top.clearlight.book.coretech.test3;

import java.util.Arrays;

public class StringSortTest {
    public static void main(String[] args) {
        String[] strArr = {"adfjlasdjf;asd", "askdfj", "adghi315hlk"};
        System.out.println(Arrays.toString(strArr));
        Arrays.sort(strArr, new LengthCoparator());
        System.out.println(Arrays.toString(strArr));
    }
}
