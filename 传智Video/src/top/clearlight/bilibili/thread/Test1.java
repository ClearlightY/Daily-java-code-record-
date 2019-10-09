package top.clearlight.bilibili.thread;

import org.junit.jupiter.api.Test;

/**
 * synchronized关键字
 * 对某个对象加锁
 */
public class Test1 {
    private int count = 10;
    private Object o = new Object();

    public void m() {
        // 任何线程要执行下面的代码, 必须先拿到o的锁
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    @Test
    void test1() {
        m();
    }

    public void m1() {
        // 任何线程要执行下面的代码, 必须先拿到this的锁
        synchronized(this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    @Test
    void test2() {
        m1();
    }

    // 等同于在方法的代码执行要synchronized(this)
    public synchronized void m2() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    @Test
    public void test3() {
        m2();
    }


}
