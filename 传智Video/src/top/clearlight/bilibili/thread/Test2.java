package top.clearlight.bilibili.thread;

import org.junit.jupiter.api.Test;

public class Test2 {
    private static int count = 10;

    // 这里等同于synchronized(Test2.class)
    /*
        也就是说, synchronized锁的是方法的调用者.
            类方法 -> 对象
            静态方法 -> 类
     */
    public synchronized static void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count=" + count);
    }

    public static void mm() {
        // 这里能够写成synchronized(this)?
        // 不可以, 因为该方法是静态方法, 不需要创建对象就可以访问该方法
        synchronized(Test2.class) {
            count--;
        }
    }

    @Test
    public void test() {
        mm();
        m();
    }
}
