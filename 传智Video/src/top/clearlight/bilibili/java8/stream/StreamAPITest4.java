package top.clearlight.bilibili.java8.stream;

import org.junit.jupiter.api.Test;
import top.clearlight.bilibili.java8.lambda.Employee;
import top.clearlight.bilibili.java8.lambda.Employee.Status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamAPITest4 {

    List<Employee> emp = Arrays.asList(
            new Employee(100, "Tary", 18, 3000, Status.BUSY),
            new Employee(100, "Mary", 58, 3000, Status.FREE),
            new Employee(100, "Tary", 18, 3000, Status.BUSY),
            new Employee(101, "Jack", 38, 3000, Status.VOCATION),
            new Employee(102, "BOb", 28, 5000, Status.BUSY),
            new Employee(103, "Aom", 48, 6000, Status.FREE)
    );

    /*
        1. 给定一个数字列表, 如何返回一个由每个数的平方构成的列表呢?
        给定[1, 2, 3, 4, 5], 应该返回[1, 4, 9, 16, 25]
     */
    @Test
    public void test1() {
        Integer[] nums = {1, 2, 3, 4, 5};

        Arrays.stream(nums)
                .map(x -> x * x)
                .forEach(System.out::println);
    }

    /*
        2. 怎样用map和reduce方法计算流中有多少个Employee?
     */
    @Test
    public void test2() {
        Optional<Integer> count = emp.stream().map(e -> 1).reduce(Integer::sum);
        System.out.println(count.get());
    }
}
