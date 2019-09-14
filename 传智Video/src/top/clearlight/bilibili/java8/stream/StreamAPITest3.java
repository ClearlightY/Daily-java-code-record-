package top.clearlight.bilibili.java8.stream;

import org.junit.jupiter.api.Test;
import top.clearlight.bilibili.java8.lambda.Employee;
import top.clearlight.bilibili.java8.lambda.Employee.Status;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 终止操作
 */
public class StreamAPITest3 {

    List<Employee> emp = Arrays.asList(
            new Employee(100, "Tary", 18, 3000, Status.BUSY),
            new Employee(100, "Mary", 58, 3000, Status.FREE),
            new Employee(100, "Tary", 18, 3000, Status.BUSY),
            new Employee(101, "Jack", 38, 3000, Status.VOCATION),
            new Employee(102, "BOb", 28, 5000, Status.BUSY),
            new Employee(103, "Aom", 48, 6000, Status.FREE)
    );

    /*
        收集
        collect -- 将流转换为其他形式。 就收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     */

    @Test
    public void test10() {
        String str = emp.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(str);
    }

    @Test
    public void test9() {
        DoubleSummaryStatistics dss = emp.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getMax());
        System.out.println(dss.getCount());
        System.out.println(dss.getSum());
        System.out.println(dss.getAverage());
    }

    // 分区
    @Test
    public void test8() {
        Map<Boolean, List<Employee>> map = emp.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 4000));
        System.out.println(map);
    }

    // 多级分组
    @Test
    public void test7() {
        Map<Status, Map<String, List<Employee>>> map = emp.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() <= 35) {
                        return "青年";
                    } else if (e.getAge() <= 50) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
        System.out.println(map);
    }

    // 分组
    @Test
    public void test6() {
        Map<Status, List<Employee>> map = emp.stream().collect(Collectors.groupingBy(Employee::getStatus));
        Set<Status> statuses = map.keySet();
        for (Status status : statuses) {
            List<Employee> employees = map.get(status);
            System.out.println(status + " : " + employees);
        }

    }

    @Test
    public void test5() {
        // 总数
        Long collect = emp.stream()
                .collect(Collectors.counting());
        System.out.println(collect);

        // 平均值
        Double avg = emp.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        // 最大值
        Optional<Employee> max = emp.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max.get());

        // 打印emp的成员
        emp.forEach(System.out::println);

        // 总和
        Double sum = emp.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        // 最小值
        Optional<Employee> min = emp.stream().collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(min.get());
    }

    @Test
    public  void test4() {
        List<String> collect = emp.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("-----------------");

        Set<String> set = emp.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        System.out.println("-----------------");

        LinkedHashSet<String> collect1 = emp.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        collect1.forEach(System.out::println);
    }

    /*
        归约
        reduce(T identity, BinaryOperator) / reduce(BinaryOperator) -- 可以将流中元素反复结合起来， 得到一个值
     */
    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Optional<Double> reduce = emp.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);

        System.out.println(reduce);
    }

    /*
        查找与匹配
        allMatch -- 检查是否匹配所有元素
        anyMatch -- 检查是否至少匹配一个元素
        noneMatch -- 检查是否没有匹配所有元素
        findFirst -- 返回第一个元素
        findAny -- 返回当前流中任意元素
        count -- 返回流中元素的总个数
        max -- 返回流中最大值
        min -- 返回流中最小值
     */

    @Test
    public void test2() {
        long count = emp.stream()
                .count();
        System.out.println(count);

        Optional<Employee> max = emp.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max.get());

        Optional<Double> min = emp.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(min.get());


    }

    @Test
    public void test1() {
        boolean b = emp.stream()
                .allMatch((e) -> e.getStatus().equals(Status.BUSY));
        System.out.println(b);

        boolean b1 = emp.stream()
                .anyMatch((e) -> e.getStatus().equals(Status.BUSY));
        System.out.println(b1);

        boolean b2 = emp.stream()
                .noneMatch((e) -> e.getStatus().equals(Status.FREE));
        System.out.println(b2);

        Optional<Employee> first = emp.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(first.get());

        Optional<Employee> any = emp.stream()
                .filter((e) -> e.getStatus().equals(Status.FREE))
                .findAny();
        System.out.println(any.get());
    }
}
