package top.clearlight.blog.java8.interfaces;

import top.clearlight.coretech.interfaces.InterfaceTest;

/**
 * Java8 接口新特性
 *
 * 1. 使用default关键字为接口定义默认方法(有实现的方法)
 * × 接口的子类`不需要`实现,可以直接使用
 * * 接口的子类也可以实现默认方法,即重写默认方法
 * * 可以有多个默认方法
 * * 实现多个接口中拥有相同的默认方法:解决方法两种分别为: 1. 重写该默认方法 2.可以使用super来调用指定接口的默认方法`指定接口.super.默认方法`
 *
 *
 * 2. 可以定义一个或多个默认方法
 * * 需要使用类名.静态方法名来调用接口中的静态方法
 */
public class InterfaceTest1 extends MyAbstract implements MyInterface, YourInterface{
    public static void main(String[] args) {
        // 匿名类
        MyInterface mi = new MyInterface() {
            @Override
            public void f1() {
                System.out.println("f1");
            }
            @Override
            public void f2() {
                System.out.println("new f2");
            }
        };

        mi.f1();
        mi.f2();
        mi.f5();
        MyInterface.f3();
        MyInterface.f4();


        InterfaceTest1 it = new InterfaceTest1();
        it.test();

        System.out.println(it.a);
        // 抽象类中的变量可变
        it.a = 2;
        System.out.println(it.a);
        // 接口中的变量不可变
        System.out.println(mi.b);
    }

    @Override
    public void f1() {
        System.out.println("realize f1");
    }

    @Override
    public void f2() {
        System.out.println("realize f2");
    }

    @Override
    public void f5() {
        System.out.println("realize f5");
    }

    @Override
    public void test() {
        // 调用指定接口的默认方法的实现
        // 因为实现的两个接口的默认方法冲突,此次需要重写该默认方法或者调用指定实现的接口中的默认方法
        // YourInterface.super.test();
        System.out.println("InterfaceTest test");
    }
}

interface MyInterface {

    int b = 1;

    void f1();

    default void f2() {
        System.out.println("f2");
    }

    default void f5() {
        System.out.println("f5");
    }

    static void f3() {
        System.out.println("f3");
    }

    static void f4() {
        System.out.println("f4");
    }

    default void test() {
        System.out.println("MyInterface test");
    }
}

interface YourInterface {
    default void test() {
        System.out.println("YourInterface test");
    }

    static void f4() {
        System.out.println("f4");
    }
}

abstract class MyAbstract {
    int a = 1;
}
