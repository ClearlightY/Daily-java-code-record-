package top.clearlight.bilibili.thread.mashibing.reentranlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronized
 * 由于m1锁定， 只有m1执行完毕的时候， m2才能执行
 *
 * 使用Reentrantlock可以完成同样的功能
 * 需要注意的是 ： 必须要必须要 手动释放锁
 * 使用syn锁定的话如果遇到异常， jvm会自动释放锁， 但是lock必须手动释放锁， 因此经常在finally中进行锁的释放
 *
 */
public class ReentrantLock1 {
    Lock lock = new ReentrantLock();

    void m1() {
            lock.lock(); // synchronized(this)
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    void m2() {
        lock.lock();
        System.out.println("m2...");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock1 r1 = new ReentrantLock1();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r1::m2).start();
    }
}
