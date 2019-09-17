package top.clearlight.bilibili.insideclass;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class InnerClassTest {
    private String name = "外部类的属性";

    public void testDemo() {
        System.out.println("这是外部类中的方法");
        int b = 1;
        int aa = 2;
        // System.out.println(++b);
        // 定义一个局部内部类
        class LocalClass {
            private String name;
            // int aa = 1;
            public void test1() {
                // aa++;
                // b++;
                // System.out.println(b);
                System.out.println("aa=" + aa);
                System.out.println(b);
            }
            public void test() {
                System.out.println(InnerClassTest.this.name);
            }
        }

        LocalClass lc = new LocalClass();
        lc.test();
        lc.test1();
        // System.out.println(lc.aa);
    }


    // 成员内部类
    public class InnerDemo {
        private String name = "内部类的属性";

        public void testDemo() {
            int a;
            // 通过外部类.this.属性名来调用同名的域,否则直接name则为就近原则
            System.out.println("这是内部类中的方法" + InnerClassTest.this.name);
        }
    }

    public void start(int interval, boolean beep) {
        Timer t = new Timer(interval, event ->
        {
            System.out.println("At the tone, the time is " + new Date());
            if (beep) Toolkit.getDefaultToolkit().beep();
        });
        t.start();
    }

    public static void main(String[] args) {
        InnerClassTest innerClassTest = new InnerClassTest();

        System.out.println(innerClassTest.name);
        innerClassTest.testDemo();

        InnerDemo id = innerClassTest.new InnerDemo();

        System.out.println(id.name);
        id.testDemo();

        innerClassTest.testDemo();

        innerClassTest.testDemo();

        int a = 1;
        System.out.println(++a);


        // Thread类
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        new Runnable() {
            @Override
            public void run() {

            }
        };


    }
}
