package top.clearlight.bilibili.java8.optoinal;

import org.junit.jupiter.api.Test;
import top.clearlight.bilibili.java8.lambda.Employee;

import java.util.Optional;

public class OptionalTest {
    /*
        Optoinal 容器类的常用方法:
        Optional.of(T t) : 创建一个Optional实例
        Optional.empty() : 创建一个空的Optional实例
        Optional.ofNullable(T t) : 若t不为null,创建Optional实例,否则创建空实例

        isPresent() : 判断是否包含值
        orElse(T t) : 如果调用对象包含值,返回该值,否则返回t
        orElseGet(Supplier s) : 如果调用对象包含值, 返回该值, 否则返回s获取的值
        map(Function f) : 如果有值对其处理,并返回处理后的Optional,否则返回Optional.empty()
        flatMap(Function mapper) : 与map类似, 要求返回值必须是Optional
     */

    @Test
    public void test3() {
        Optional<Employee> op = Optional.ofNullable(null);

        if (op.isPresent()) {
            System.out.println(op.get());
        }

        Employee emp = op.orElse(new Employee(1, "张三", 88, 2000, Employee.Status.FREE));
        System.out.println(emp);
    }

    @Test
    public void test2() {
        Optional<Object> op = Optional.empty();
        System.out.println(op.get());
    }

    @Test
    public void test1() {
        Optional<Employee> op = Optional.of(new Employee());
        Employee emp = op.get();
        System.out.println(emp);

        /*Optional<Employee> op = Optional.of(null);
        Employee emp = op.get();
        System.out.println(emp);*/
    }
}
