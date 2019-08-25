package cn.com.clearlight.generics.test;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericsTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");

        Iterator<String> iterator = arrayList.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
