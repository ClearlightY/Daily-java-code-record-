package cn.com.clearlight.setframe.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListForeachDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.forEach(System.out::println);

        Iterator<Integer> it = list.iterator();
        it.forEachRemaining(System.out::println);
    }
}
