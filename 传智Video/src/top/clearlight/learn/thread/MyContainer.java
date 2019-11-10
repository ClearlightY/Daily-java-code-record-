package top.clearlight.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 实现一个容器, 提供两个方法, add, size
 * 写两个线程, 线程1添加10个元素到容器中, 线程2实现监控元素的个数, 当个数到5个时, 线程2给出提示并退出
 */
public class MyContainer {
    volatile List list = new ArrayList<>();

    public void add(Object object) {
        list.add(object);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer mc = new MyContainer();
        new Thread(() -> {
            while (true) {
                if (mc.size() == 5) {
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName() + "退出");
        }, "t2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                mc.add(new Object());
                System.out.println("add");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
