package top.clearlight.bilibili.thread.synchronizedtest;

import java.util.concurrent.TimeUnit;

/**
 * 一个同步方法可以调用另外一个同步方法, 一个线程已经拥有某个对象的锁, 再次申请的时候仍然会得到该对象的锁
 * 也就是说synchronized获得的锁是可重入的
 *
 * @date 2019.9.2
 */
public class Test5 {
    synchronized void m1() {
        System.out.println("m1.start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 同一个线程里,调用m1方法时的对象已经有了一把锁, 当调用m2时,重新申请已经拥有的这把锁,(即锁定了两次)再次申请的时候仍然会得到该对象的锁
        m2();
    }

    synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }
}
