package top.clearlight.bilibili.thread.synchronizedtest;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile并不能保证多个线程共同修改running变量时锁带来的不一致问题, 也就是说volatile不能代替synchronized
 * <p>
 * synchronized : 既有可见性, 又有原子性
 * volatile : 只有可见性
 */
public class Test9 {
    /*volatile*/ int count = 0;


    synchronized void m() {
        for (int i = 0; i < 1000000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        Test9 t = new Test9();

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
