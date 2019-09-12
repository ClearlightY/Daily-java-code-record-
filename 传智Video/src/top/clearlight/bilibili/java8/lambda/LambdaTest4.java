package top.clearlight.bilibili.java8.lambda;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * 方法引用：若Lambda体中的内容有方法实现了，我们可以使用“方法引用”
 * （可以理解为方法引用是Lambda表达式的另外一种表达形式）
 * <p>
 * 主要有三种语法格式：
 * <p>
 * 对象：：实例方法名
 * <p>
 * 类：：静态方法名
 * <p>
 * 类：：实例方法名
 * <p>
 * 注意：
 * 1. Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致！
 * 2. 若Lambda参数列表中的第一参数是 实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
 * <p>
 * 二、构造器引用：
 * <p>
 * 格式：
 * ClassName::new
 * <p>
 * 注意： 需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致
 * <p>
 * 三、数组引用：
 *
 * Type::new;
 */
public class LambdaTest4 {

    // 数组引用
    @Test
    public void test7() {
        Function<Integer, String[]> fun = (x) -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        Function<Integer, String[]> fun2 = String[]::new;
        String[] strs2 = fun2.apply(20);
        System.out.println(strs2.length);
    }

    // 构造器引用
    @Test
    public void test5() {
        Supplier<Employee> sup = () -> new Employee();

        // 构造器引用方式
        Supplier<Employee> sup1 = Employee::new;
        Employee employee = sup1.get();
        System.out.println(employee);
    }

    @Test
    public void test6() {
        Function<Integer, Employee> fun = (x) -> new Employee(x);

        Function<Integer, Employee> fun1 = Employee::new;
        System.out.println(fun1.apply(10));

        BiFunction<Integer, Integer, Employee> bf = Employee::new;
        System.out.println(bf.apply(20, 2));
    }

    // 类：：实例方法名
    @Test
    public void test4() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);

        BiPredicate<String, String> bp2 = String::equals;
        boolean test = bp2.test("aa", "aa");
        System.out.println(test);

    }

    // 类：：静态方法名
    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com2 = Integer::compare;

        int compare = com2.compare(10, 8);
        System.out.println(compare);

    }

    // 对象：：实例方法名
    @Test
    public void test1() {
        Consumer<String> con = (x) -> System.out.println(x);

        PrintStream out = System.out;
        Consumer<String> c = out::println;

        Consumer<String> con1 = System.out::print;
        con1.accept("Lambda方法引用");
    }

    // 对象：：实例方法名
    @Test
    public void test2() {
        Employee emp = new Employee();
        Supplier<String> sup = () -> emp.getName();

        String str = sup.get();
        System.out.println(str);

        Supplier<Integer> sup2 = emp::getAge;
        System.out.println(sup2.get());
    }
}
