package top.clearlight.bilibili.thread.mashibing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 解决同样的问题的更高效的方法, 使用AtomXXX类
 * AtomXXX类本身方法都是原子性的, 但不能保证多个方法连续调用是原子性的
 */
public class Test10 {
    // volatile int count = 0;

    AtomicInteger count = new AtomicInteger(0);

    /*synchronized*/ void m() {
        for (int i = 0; i < 1000000; i++) {
            // count++;
            count.incrementAndGet(); // count++
        }
    }

    public static void main(String[] args) {
        Test10 t = new Test10();

        List<Thread> threads = new ArrayList<>();

        long start = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }

        threads.forEach(Thread::start);

        threads.forEach(o -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long end = System.currentTimeMillis();
        System.out.println(t.count);
        System.out.println("消耗的时间为: " + (end - start));
    }
}
