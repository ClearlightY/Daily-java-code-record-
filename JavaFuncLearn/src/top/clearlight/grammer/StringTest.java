package top.clearlight.grammer;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        String a = "1230 abc. ";
        System.out.println(a.indexOf((char)'0'));
        System.out.println(a.indexOf((char)0));
        String b = "";
        System.out.println("b?" + Arrays.toString(b.toCharArray()));
        System.out.println(b.indexOf((char)0));
        System.out.println((char)0);
        System.out.println((char)'0');
        String c = new String(" ");
        System.out.println(c.indexOf((char)0));

        System.out.println("".equals((char)0));
        System.out.println("".toCharArray()[0]);
    }
}
