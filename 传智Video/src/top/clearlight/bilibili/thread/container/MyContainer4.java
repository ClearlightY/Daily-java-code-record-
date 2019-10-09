package top.clearlight.bilibili.thread.container;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 这里使用wait和notify做到, wait会释放锁, 而notify不会释放锁
 * <p>
 * 需要注意的是, 运用这种方法, 必须要保证t2先执行, 也就是首先让t2监听才可以
 * <p>
 * 阅读下面程序, 分析输出结果
 * 可以读到输出结果并不是size=5时t2退出, 而是t1结束时t2才接受到通知而退出
 * 因为notify之后, t1必须释放锁, t2退出后, 也必须notify, 通知t1继续执行
 * 整个通信过程比较繁琐
 * <p>
 * 使用Latch(门闩)替代wait notify来进行通知
 * 好处是通信方式简单, 同事也可以指定等待时间
 * 使用await和countdown方法替代wait和notify
 * CountDownLatch不涉及锁定, 当count的值为零时当前线程继续运行
 * 当不涉及同步, 只是涉及线程通信的时候, 用synchronized + wait/notify就显得太重了
 * 这是应该考虑CountDownLatch/CyclicBarrier/semaphore
 */
public class MyContainer4 {

    // 添加volatile, 使t2能够得到通知
    volatile List list = new ArrayList();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer4 mc = new MyContainer4();

        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2启动");
            if (mc.size() != 5) {
                try {
                    // 等待, 但是不加锁
                    latch.await();

                    //也可以指定等待时间
                    // Latch.await(5000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2结束");
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("t1启动");
            for (int i = 0; i < 10; i++) {
                mc.add(new Object());
                System.out.println("add " + i);

                if (mc.size() == 5) {
                    // 打开门闩, 让t2得以执行
                    latch.countDown();
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1结束");
        }, "t1").start();

    }
}
