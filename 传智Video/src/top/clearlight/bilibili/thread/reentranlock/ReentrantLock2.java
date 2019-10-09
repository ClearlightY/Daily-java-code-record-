package top.clearlight.bilibili.thread.reentranlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronized
 * 由于m1锁定， 只有m1执行完毕的时候， m2才能执行
 *
 * 使用ReentrantLock可以完成同样的功能
 * 需要注意的是 ： 必须要必须要 手动释放锁
 * 使用syn锁定的话如果遇到异常， jvm会自动释放锁， 但是lock必须手动释放锁， 因此经常在finally中进行锁的释放
 *
 * 使用ReentrantLock可以进行"尝试锁定"tryLock, 这样无法锁定, 或者在指定时间内无法锁定, 线程可以决定是否继续等待
 */
public class ReentrantLock2 {
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


    /**
     * 使用tryLock进行尝试锁定, 不管锁定与否, 方法都将继续执行
     * 也可以根据tryLock的返回值来判定是否锁定
     * 也可以指定tryLock的时间, 由于tryLock(time)抛出异常, 所以要注意unlock的处理, 必须要放到finally中
     */
    void m2() {
      /* boolean locked = lock.tryLock();
        System.out.println("m2..." + locked);
        if (locked) {
            lock.unlock();
        }*/
      boolean locked = false;
        try {
            locked = lock.tryLock(12, TimeUnit.SECONDS);
            System.out.println("m2..." + locked);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock2 r1 = new ReentrantLock2();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r1::m2).start();
    }
}
