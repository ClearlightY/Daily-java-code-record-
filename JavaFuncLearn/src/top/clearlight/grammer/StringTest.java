package top.clearlight.grammer;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        String a = "1230 abc. ";
        System.out.println(a.indexOf((char) '0'));
        System.out.println(a.indexOf((char) 0));
        String b = "";
        System.out.println("b?" + Arrays.toString(b.toCharArray()));
        System.out.println(b.indexOf((char) 0));
        System.out.println((char) 0);
        System.out.println((char) '0');
        String c = new String(" ");
        System.out.println(c.indexOf((char) 0));

        System.out.println("".equals((char) 0));
        // System.out.println("".toCharArray()[0]);

        // System.out.println("" == (char)0);

        String str = "";
        for (int i = 0; i < 10; i++) {
            str = i + " ";
            System.out.println(str);
        }

        String temp1 = "201704";
        System.out.println(temp1.substring(0,4));
        System.out.println(temp1.substring(5));
    }
}
