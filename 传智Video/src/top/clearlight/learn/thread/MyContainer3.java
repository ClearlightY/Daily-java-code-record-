package top.clearlight.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MyContainer3 {
    // 添加volatile, 使t2能够得到通知
    volatile List list = new ArrayList();

    public void add(Object object) {
        list.add(object);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer3 mc = new MyContainer3();

        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2启动");
            if (mc.size() != 5) {
                try {
                    latch.await();
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
                System.out.println("add" + i);

                if (mc.size() == 5) {
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
