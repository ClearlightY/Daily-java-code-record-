package top.clearlight.bilibili.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaTest2 {

    List<Employee> emp = Arrays.asList(
            new Employee(100, "Tary", 18, 2000),
            new Employee(101, "Jack", 38, 3000),
            new Employee(102, "BOb", 28, 5000),
            new Employee(103, "Aom", 18, 6000)
    );

    @Test
    public void test3() {
        long l = opertor1(123, 124, (x, y) -> x + y);
        System.out.println(l);

        long l1 = opertor1(152, 325, (x, y) -> x * y);
        System.out.println(l1);

        BiFunction<Double, Double, Double> bf = Math::pow;
        Double apply = bf.apply(2.0, 3.0);
        System.out.println(apply);
    }

    public long opertor1(long a, long b, MyGeneric<Long, Long> mg) {
        return mg.oper(a, b);
    }

    @Test
    public void test2() {
        String str = operator("aldsfjkwei", (x) -> x.toUpperCase().substring(2, 5));
        System.out.println(str);

        Function<String, String> f = String::toUpperCase;
        String strs = f.apply("abcdefg");
        System.out.println(strs);
    }

    public String operator(String str, MyGetValue my) {
        return my.getValue(str);
    }

    @Test
    public void test1() {
       /* Collections.sort(emp, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return e1.getAge() - e2.getAge();
            }
        });*/

       /*Collections.sort(emp, (e1, e2) -> e1.getAge() == e2.getAge() ? e1.getName().compareTo(e2.getName()) : e1.getAge() - e2.getAge());

        for (Employee employee : emp) {
            System.out.println(employee);
        }*/

        BiFunction<Integer, Integer, Integer> bf = Integer::compare;
        // bf.apply()
        Collections.sort(emp, (e1, e2) -> bf.apply(e1.getAge(), e2.getAge()));

        for (Employee employee : emp) {
            System.out.println(employee);
        }


    }

}
