package top.clearlight.bilibili.thread.feiyangedu.interrupt;

/**
 * 通过标志位来中断线程
 * volatile关键字解决了共享变量在线程间的可见性问题
 */
class ThreadInterrupt1 extends Thread {
    volatile boolean running = true;

    @Override
    public void run() {
        int i = 0;
        while (running) {
            i++;
            System.out.println("hello" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                break;
            }
        }
        System.out.println("Thread end");
    }
}

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        ThreadInterrupt1 ti = new ThreadInterrupt1();
        ti.start();
        Thread.sleep(1000);
        // 更改标志位
        ti.running = false;
        System.out.println("Main end");
    }
}