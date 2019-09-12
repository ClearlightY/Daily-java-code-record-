package top.clearlight.bilibili.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 内置的四大核心函数式接口
 * <p>
 * Consumer<T> : 消费性接口
 * void accept(T t);
 * Supplier<T> : 供给型接口
 * T get();
 * Function<T, R> : 函数式接口
 * R apply(T t);
 * Predicate<T> : 断言型接口
 * boolean test(T t);
 */
public class LambdaTest3 {

    // Predicate<T> : 断言型接口
    @Test
    public void test4() {
        List<String> list = Arrays.asList("Hello", "World", "What", "the", "fuck");
        System.out.println(boolPre(list, (String s) -> s.length() > 3));
    }

    public List<String> boolPre(List<String> list, Predicate<String> pre) {
        List<String> aList = new ArrayList();

        for (String s : list) {
            if (pre.test(s)) {
                aList.add(s);
            }
        }

        return aList;
    }

    // Function<T> 函数式接口
    @Test
    public void test3() {
        String str1 = getStrList("aslkfjadf", s -> s.toUpperCase());
        System.out.println(str1);

        String str2 = getStrList("asdklfj", s -> s.substring(2, 5));
        System.out.println(str2);
    }

    public String getStrList(String s, Function<String, String> fun) {
        return fun.apply(s);
    }

    // Supplier<T> 供给型接口
    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> new Random().nextInt(10) + 1);
        System.out.println(numList);
    }

    // 需求： 产生指定个数的整数， 并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }

        return list;
    }

    // Consumer<T> 消费型接口
    @Test
    public void test1() {
        happy(1000, m -> System.out.println("吃喝玩乐" + m + "元"));
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }
}
