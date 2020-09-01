package top.clearlight.grammer;

import java.util.ArrayList;
import java.util.List;

public class StringLearn {
    public static void main(String[] args) {
        String s = "a";
        String s2 = "a";
        System.out.println(s == s2);
        System.out.println(s);
        String s1 = new String("a");
        System.out.println(s1);
        List list = new ArrayList<Object>();
        System.out.println(list);
        System.out.println("s1 == s2 ? " + s1==s2);

        int[] a = {1, 2};
        System.out.println(a);

        int i = System.identityHashCode(s);
        System.out.println(i);
        System.out.println(s.hashCode());

        Integer.valueOf(1);
    }
}
