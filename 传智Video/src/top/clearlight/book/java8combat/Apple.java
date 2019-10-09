package top.clearlight.book.java8combat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Apple {
    int weight;

    public Apple() {

    }

    public Apple(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "ooooo" + this.weight;
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Apple a = new Apple();

        // 一个完整的简化过程:
        // 复杂方法(需要重新写接口来实现) -> 匿名内部类 -> Lambda表达式 -> 方法引用
        Supplier<Apple> b = new Supplier<Apple>() {
            @Override
            public Apple get() {
                return new Apple();
            }
        };
        System.out.println(b.get().toString());
        Supplier<Apple> c = () -> new Apple();
        Supplier<Apple> d = Apple::new;

        // 调用一个参数的构造函数
        Function<Integer, Apple> apple = new Function<Integer, Apple>() {
            @Override
            public Apple apply(Integer t) {
                //  TODO Auto-generated method stub
                return new Apple(t);
            }
        };
        Apple app = apple.apply(1);
        System.out.println(app.toString());
        Function<Integer, Apple> apple1 = (t) -> new Apple(t);
        Function<Integer, Apple> apple2 = Apple::new;
        Apple app1 = apple2.apply(2);
        System.out.println(app1.toString());

        // 创建一个线程
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("oo");
            }
        });
        Thread thread = new Thread(() -> System.out.println("oo"));
        Thread thread1 = new Thread(System.out::println);

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);

        System.out.println(apples);
    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer e : list) {
            result.add(f.apply(e));
        }
        return result;
    }
}
