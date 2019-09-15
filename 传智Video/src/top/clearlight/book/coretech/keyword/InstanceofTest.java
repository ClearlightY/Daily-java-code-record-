package top.clearlight.book.coretech.keyword;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

public class InstanceofTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        System.out.println(list instanceof List);
        System.out.println(list instanceof ArrayList);
        System.out.println(list instanceof AbstractList);
        System.out.println(list instanceof Object);
        System.out.println(list instanceof RandomAccess);
        System.out.println(list instanceof Serializable);

        System.out.println(null instanceof List);
        // System.out.println('a' instanceof Character);
    }
}
