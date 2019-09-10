package top.clearlight.bilibili.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * lambda表达式
 *
 * Java8引入新的操作符“->”，箭头操作符将Lambda分成两部分：
 * 左侧：Lambda表达式的参数列表
 * 右侧：Lambda表达式中所需执行的功能，即Lambda体
 *
 * 语法格式一：无参数，无返回值
 *      () -> System.out.println("Hello Lambda!");
 *
 * 语法格式二：有一个参数，并且无返回值
 *      (x) -> System.out.println(x);
 *
 * 语法格式三：若只有一个参数，小括号可以省略不写
 *      x -> System.out.println(x);
 *
 * 语法格式四：有两个以上的参数，有返回值，并且Lambda体中有多条语句
 *      Comparator<Integer> com = (x, y) -> {
 *          System.out.println("函数式接口");
 *          return Integer.compare(x, y);
 *      }
 *
 * 语法格式五：若Lambda体中只有一条语句，return和大括号都可以省略不写
 *      Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 *
 * 语法格式六：(JDK1.7之后) Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即”类型推断“
 *      (Integer x, Integer y) -> Integer.compare(x, y);
 *
 * 二、Lambda表达式需要”函数式接口“的支持
 * 函数式接口：接口中只有一个抽象方法的接口，成为函数式接口。可以使用@FunctionalInterface
 *           可以检查是否是函数式接口
 *
 */
public class LambdaTest {

    @Test
    public void test1() {
        int num = 0; // JDK1.7前，必须要写final
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!" + num);
            }
        };
        r.run();

        Runnable r1 = () -> System.out.println("Hello lambda");
        r1.run();
    }

    @Test
    public void test2() {
        Consumer<String> con = x -> System.out.println(x);
        con.accept("hhhhhhd");
    }

    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test4() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }


    // 需求：对一个数进行运算
    @Test
    public void test6() {
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);
    }

    public Integer operation(Integer num, MyFun myFun) {
        return myFun.getValue(num);
    }
}
