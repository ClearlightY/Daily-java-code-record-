package top.clearlight.bilibili.thread.synchronizedtest;

import java.util.concurrent.TimeUnit;

/**
 * 一个同步方法调用另外一个同步方法, 一个线程已经拥有某个对象的锁, 再次申请的时候仍然会得到该对象的锁.
 * 也就是说synchronized获得的锁是可重入的
 * 这里是继承中有可能发生的情形, 子类调用父类的同步方法
 */
public class Test6 {
    synchronized void m() {
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        // 子类的同步方法调用父类的同步方法(重入锁的另外一种形式),不会造成死锁,这是可以的
        new T().m();
    }
}

class T extends Test6 {
    @Override
    synchronized void m() {
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}
