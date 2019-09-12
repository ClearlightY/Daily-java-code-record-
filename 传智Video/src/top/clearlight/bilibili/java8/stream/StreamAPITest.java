package top.clearlight.bilibili.java8.stream;

import org.junit.jupiter.api.Test;
import top.clearlight.bilibili.java8.lambda.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream的三个操作步骤：
 *
 * 1. 创建Stream
 *
 * 2. 中间操作
 *
 * 3. 终止操作（终端操作）
 */
public class StreamAPITest {

    // 创建Stream
    @Test
    public void test1() {
        // 1. 可以通过Collection系列集合提供的stream（）或parallelStream（）
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        // 2. 通过Arrays中的静态方法stream（）获取数组流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(employees);

        // 3. 通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        // 4. 创建无限流
        // 迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 1);
        stream4.limit(10).forEach(System.out::println);

        // 生成
        Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);

    }
}
