package top.clearlight.bilibili.thread.mashibing.container2;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 面试题: 写一个固定容量同步容器, 拥有put和get方法, 以及getCount方法,
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * <p>
 * 使用wait和notify/notifyAll来实现
 *
 * @date 2019.09.28
 */
public class MyContainer1<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10; // 最多10个元素
    private int count = 0;

    public synchronized void put(T t) {
        // 想想为什么用while而不用if
        if (lists.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.add(t);
        ++count;
        // 通知消费者线程进行消费
        this.notifyAll();
    }

    public synchronized T get() {
        T t = null;
        if (lists.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = lists.removeFirst();
        count--;
        // 通知生产者进行生产
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        MyContainer1 mc = new MyContainer1();
        // 启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(mc.get());
                }
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 启动生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    mc.put(Thread.currentThread().getName() + " " + j);
                }
            }, "p" + i).start();
        }
    }
}
