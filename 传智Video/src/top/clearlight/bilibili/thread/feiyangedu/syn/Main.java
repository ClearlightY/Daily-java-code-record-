package top.clearlight.bilibili.thread.feiyangedu.syn;

/**
 * 对共享变量进行写入时, 必须保证是原子操作
 * 原子操作是指不能被中断的一个或一系列操作
 */
class AddThread extends Thread {
    public void run() {
        for (int i = 0; i < Main.LOOP; i++) {
            synchronized (Main.lock) {
                Main.count += 1;
            }
        }
    }
}

class DecThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < Main.LOOP; i++) {
            synchronized (Main.lock) {
                Main.count -= 1;
            }
        }
    }
}

public class Main {
    static final int LOOP = 100000;
    static int count = 0;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new AddThread();
        Thread t2 = new DecThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
