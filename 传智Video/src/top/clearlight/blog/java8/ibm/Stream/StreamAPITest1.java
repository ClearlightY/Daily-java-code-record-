package top.clearlight.blog.java8.ibm.Stream;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPITest1 {

    // 流转换为其他数据结构
    @Test
    public void test3() {
        Stream<String> stream = new ArrayList<String>().stream();
        // 1. Array
        String[] strings = stream.toArray(String[]::new);

    }

    // 数值流的构造
    @Test
    public void test2() {
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 10).distinct().forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
    }

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list = Arrays.asList("aaa", "dvdsa", "a", "ad");
        // list.stream();

        String[] strs = new String[]{"aa", "bb", "cc"};
        String reduce = Arrays.stream(strs).limit(2).reduce("", String::concat);
        System.out.println(reduce);

        Stream.of("aa", "bbc", "ccaaa", "dd").skip(1).filter((e) -> e.length() > 2).sorted(String::compareTo).forEach(System.out::println);

        System.out.println("--------------------");

        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 2;
            }
        }).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        Reader r = new Reader() {
            @Override
            public int read(char[] cbuf, int off, int len) throws IOException {
                return 0;
            }

            @Override
            public void close() throws IOException {

            }
        };
        BufferedReader br = new BufferedReader(r);

        // br.lines()
    }
}
