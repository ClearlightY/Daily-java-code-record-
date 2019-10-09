package top.clearlight.bilibili.thread.reentranlock;

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
 * <p>
 * ReentrantLock还可以指定为公平锁
 */
public class ReentrantLock4 extends Thread{
    // 参数为true表示为公平锁, 请对比输出结果
    private static ReentrantLock lock = new ReentrantLock(true);

    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock4 r = new ReentrantLock4();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        // 谁等待的时间长, 让谁得到那把锁
        t1.start();
        t2.start();
    }
}
