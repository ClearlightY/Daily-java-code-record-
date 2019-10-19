package top.clearlight.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyContainer2 {
    volatile List list = new ArrayList<>();

    public void add(Object object) {
        list.add(object);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer2 mc = new MyContainer2();

        final Object lock = new Object();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            synchronized (lock) {
                if (mc.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "退出");
                lock.notify();
            }
        }, "t2").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    mc.add(new Object());
                    System.out.println("add" + i);
                    if (mc.size() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();
    }
}
