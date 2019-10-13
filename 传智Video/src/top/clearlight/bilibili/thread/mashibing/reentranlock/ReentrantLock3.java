package top.clearlight.bilibili.thread.mashibing.reentranlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronized
 * 由于m1锁定， 只有m1执行完毕的时候， m2才能执行
 * <p>
 * 使用ReentrantLock可以完成同样的功能
 * 需要注意的是 ： 必须要必须要 手动释放锁
 * 使用syn锁定的话如果遇到异常， jvm会自动释放锁， 但是lock必须手动释放锁， 因此经常在finally中进行锁的释放
 * <p>
 * 使用ReentrantLock可以进行"尝试锁定"tryLock, 这样无法锁定, 或者在指定时间内无法锁定, 线程可以决定是否继续等待
 * <p>
 * 使用ReentrantLock还可以调用lockInterruptibly方法, 可以对线程interrupt方法做出响应,
 * 在一个线程等待锁的过程中, 可以被打断
 */
public class ReentrantLock3 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            try {
                lock.lock(); // synchronized(this)
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                // TimeUnit.SECONDS.sleep(4);
                System.out.println("t1 end");
            } catch (InterruptedException e) {
                System.out.println("interrupted!");
            } finally {
                lock.unlock();
            }
        });
        t1.start();

        System.out.println("----------------");

        Thread t2 = new Thread(() -> {
            try {
                // lock.lock();
                lock.lockInterruptibly(); // 可以对interrupt()方法做出响应
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                System.out.println("interrupted!");
            } finally {
                if (lock.tryLock()) {
                    lock.unlock();
                }
            }
        });
        t2.start();

        // 5秒中之后执行后面的代码.
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("???????????");
        t2.interrupt(); // 打断线程2的等待
    }
}
