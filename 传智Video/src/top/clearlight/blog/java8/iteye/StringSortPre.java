package top.clearlight.blog.java8.iteye;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class StringSortPre {

    String startWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    @Test
    public void test3() {
        Function<String, String> f = this::startWith;
        String s = f.apply("Java");
        System.out.println(s);

        Stream.of(s).forEach(System.out::println);
    }

    @Test
    public void test2() {
        StringSortPre ssp = new StringSortPre();
        Function<String, String> f = ssp::startWith;
        String str = f.apply("Java");
        System.out.println(str);
    }

    @Test
    public void test1() {
        List<String> list = Arrays.asList("peter", "mary", "jack", "bob");

        // Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
        list.sort(String::compareTo);

        System.out.println(list);
    }

    @Test
    public void test() {
        List<String> list = Arrays.asList("peter", "mary", "jack", "bob");

        System.out.println(list);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(list);

    }
}
