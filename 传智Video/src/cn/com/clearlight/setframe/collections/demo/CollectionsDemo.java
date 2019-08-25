package cn.com.clearlight.setframe.collections.demo;

import cn.com.clearlight.setframe.collections.comparator.comparatorByLength;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("ab");
        list.add("ddas");
        list.add("adflkj");
        list.add("zzkj");
        System.out.println(list);

        // 对list集合进行指定顺序的排序
        mySort(list, new comparatorByLength());
        // Collections.sort(list);
        System.out.println(list);
    }

    private static <T> void mySort(List<T> list, Comparator<? super T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
               /* if (list.get(i).compareTo(list.get(j)) > 0) {
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }*/
                if (comparator.compare(list.get(i), list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
