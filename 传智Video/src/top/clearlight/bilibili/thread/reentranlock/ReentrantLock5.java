package top.clearlight.bilibili.thread.reentranlock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock5 extends Thread{
    private static ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock5 r = new ReentrantLock5();

        new Thread(r, "t1").start();
        new Thread(r, "t2").start();
    }
}
