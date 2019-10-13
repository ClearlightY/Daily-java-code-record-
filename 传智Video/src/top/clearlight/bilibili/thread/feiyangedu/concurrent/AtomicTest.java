package top.clearlight.bilibili.thread.feiyangedu.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

class Counter2 {
    private AtomicInteger value = new AtomicInteger(0);

    public int add(int m) {
        return this.value.addAndGet(m);
    }

    public int dec(int m) {
        return this.value.addAndGet(-m);
    }

    public int get() {
        return this.value.get();
    }

}

public class AtomicTest {

    final static int LOOP = 100;

    public static void main(String[] args) throws InterruptedException {
        Counter2 c = new Counter2();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < LOOP; i++) {
                c.add(1);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < LOOP; i++) {
                c.dec(1);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c.get());
    }
}
