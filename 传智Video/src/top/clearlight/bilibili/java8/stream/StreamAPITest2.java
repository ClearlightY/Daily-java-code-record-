package top.clearlight.bilibili.java8.stream;

import org.junit.jupiter.api.Test;
import top.clearlight.bilibili.java8.lambda.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream的三个操作步骤：
 * <p>
 * 1. 创建Stream
 * <p>
 * 2. 中间操作
 * 多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理！
 * 而在终止操作时一次性全部处理，称为”惰性求值".
 * 3. 终止操作（终端操作）
 */
public class StreamAPITest2 {

    List<Employee> emp = Arrays.asList(
            new Employee(100, "Tary", 18, 3000),
            new Employee(100, "Mary", 18, 3000),
            new Employee(100, "Oary", 18, 3000),
            new Employee(101, "Jack", 38, 3000),
            new Employee(102, "BOb", 28, 5000),
            new Employee(103, "Aom", 18, 6000)
    );

    // 中间操作

    /*
        排序
        sorted() -- 自然排序（Comparable）
        sorted(Comparator com) -- 定制排序(Comparator)
     */
    @Test
    public void test7() {
        List<String> list = Arrays.asList("zzz", "bbb", "ccc", "ddd", "eee");

        list.stream()
                .sorted()
                .forEach(System.out::println);

        emp.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge() == e2.getAge()) {
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return e1.getAge() - e2.getAge();
                    }
                })
                .forEach(System.out::println);
    }

    /*
        映射
        map -- 接受Lambda, 将元素转换成其他形式或提取信息.接受一个函数作为参数,该函数会被应用到每个元素上,并将其映射成一个新的元素.
        flatMap -- 接受一个函数作为参数,将流中的每个值都换成另一个流,然后把所有流连接成一个流
     */

    @Test
    public void test6() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        List list1 = new ArrayList();

        list1.add(1);
        list1.add("adsf");
        list1.add(list);
        // list1.addAll(list);

        System.out.println(list1);
    }

    @Test
    public void test5() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("-----------------");

        emp.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("-----------------");

        Stream<Stream<Character>> streamStream = list.stream()
                .map(StreamAPITest2::filterCharacter);
        streamStream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });

        System.out.println("------------------");

        Stream<Character> characterStream = list.stream()
                .flatMap(StreamAPITest2::filterCharacter);

        characterStream.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }

        return list.stream();
    }

    /*
        筛选与切片
        filter -- 接收Lambda，从从流中排除某些元素
        limit -- 截断流，使其元素不超过给定数量
        skip（n） -- 跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit（n)互补
        distinct -- 筛选， 通过流所生成元素的hashCode（）和equals（）去除重复元素 // 类需要重写equals和hashCode方法
     */

    @Test
    public void test4() {
        emp.stream()
                .filter(e -> e.getSalary() > 2000)
                .skip(1)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        emp.stream()
                .filter((e) -> {
                    System.out.println("短路!");
                    return e.getSalary() > 2000;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    // 内部迭代: 迭代操作有StreamAPI 完成
    @Test
    public void test1() {
        // 中间操作 ： 不会执行任何操作
        emp.stream().filter((e) -> {
            System.out.println("Stream API 的中间操作");
            return e.getAge() > 20;
        })
                // 终止操作 ： 一次性执行全部内容，即“惰性求职”
                .forEach(System.out::println);
    }

    // 外部迭代 :
    @Test
    public void test2() {
        Iterator<Employee> it = emp.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}












