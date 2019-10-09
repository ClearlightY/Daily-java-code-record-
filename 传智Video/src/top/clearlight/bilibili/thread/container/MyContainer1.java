package top.clearlight.bilibili.thread.container;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 面试题:
 * 实现一个容器, 提供两个方法, add, size
 * 写两个线程, 线程1添加10个元素到容器中, 线程2实现监控元素的个数, 当个数到5个时, 线程2给出提示并结束
 */
public class MyContainer1 {
    volatile List list = new ArrayList();

    /*int i = 0;
    public List add() {
        list.add(i++);
        return list;
    }*/
    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer1 mc = new MyContainer1();
        // new thread(mc::add, "t1").start();
        // new thread(() -> mc.size(list), "t2");

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                mc.add(new Object());
                System.out.println("add" + i);

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                if (mc.size() == 5) {
                    // System.exit(0);
                    break;
                }
            }
            System.out.println("t2结束");
        }, "t2").start();
    }
}
