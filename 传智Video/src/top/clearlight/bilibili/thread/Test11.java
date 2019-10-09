package top.clearlight.bilibili.thread;

import java.util.concurrent.TimeUnit;

/**
 * synchronized优化
 * 同步代码块中的语句越少越好
 * 比较m1和m2
 */
public class Test11 {
    int count = 0;

    synchronized void m1() {
        // do sth need note sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 业务逻辑中只有下面这句需要sync, 这是不用该给整个方法上锁
        count++;

        // do sth need not sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void m2() {
        // do sth need not sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 业务逻辑中只有下面这句需要sync, 这是不应该给整个方法上锁
        // 采用细粒度的锁, 可以使线程争用时间变短, 从而提高效率
        synchronized (this) {
            count++;
        }
        // do sth need not sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
