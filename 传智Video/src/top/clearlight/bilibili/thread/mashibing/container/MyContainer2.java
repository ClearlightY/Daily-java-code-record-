package top.clearlight.bilibili.thread.mashibing.container;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 面试题:
 * 实现一个容器, 提供两个方法, add, size
 * 写两个线程, 线程1添加10个元素到容器中, 线程2实现监控元素的个数, 当个数到5个时, 线程2给出提示并结束
 * <p>
 * 给list添加volatile之后, t2能够就到通知, 但是, t2线程的死循环很浪费cpu, 如果不用死循环该如何做?
 * <p>
 * 这里使用wait和notify做到, wait会释放锁, 而notify不会释放锁
 * 需要注意的是, 运用这种方法, 必须要保证t2先执行, 也就是首先让t2监听才可以
 * <p>
 * 分析输出结果
 * 可以读到输出结果并不是size=5时t2退出, 而是t1结束时t2才接受到通知而退出
 * 想想这是why?
 * 该程序并没有解决该问题, 出现这样的原因是notify唤醒等待的线程后, 但是并没有释放lock锁, 因此t2线程无法继续执行
 */
public class MyContainer2 {

    // 添加volatile, 使t2能够得到通知
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

        final Object lock = new Object();

        // 给对象o加锁, 不满足条件, 则执行wait, 使当前线程进入等待状态, 同时释放锁
        // 先启动t2线程进行监听, 然后在启动t1线程
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2启动");
                if (mc.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2结束");
            }
        }, "t2").start();

        new Thread(() -> {
           // notify会启动正在这个对象上等待的某一个线程, notifyAll叫醒这个对象上的所有线程, 但是并没有释放这个对象的锁
            System.out.println("t1启动");
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    mc.add(new Object());
                    System.out.println("add " + i);

                    if (mc.size() == 5) {
                        lock.notify();
                    }

                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();
    }
}

