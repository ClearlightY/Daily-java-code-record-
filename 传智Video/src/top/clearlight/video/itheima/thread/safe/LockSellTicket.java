package top.clearlight.video.itheima.thread.safe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSellTicket implements Runnable {
    private int ticket = 100;

    Lock lock = new ReentrantLock();

    // 同步方法
    @Override
    public /*synchronized*/ void run() {
        System.out.println("this :" + this);
        while (true) {
            lock.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + ":" + ticket--);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new SellCinemaTicket();

        System.out.println(r);

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t1.join();
        t2.start();
        // t2.join();
        // t3.start();
        // t3.join();
        System.out.println("Main end");
    }
}
