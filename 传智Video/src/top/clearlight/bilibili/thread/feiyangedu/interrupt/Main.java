package top.clearlight.bilibili.thread.feiyangedu.interrupt;

/**
 * 通过调用interrupt方法来中断线程,isInterrupt来获取当前线程是否已中断,true表示线程中断
 * 如果线程处于等待状态, 该线程会捕获InterruptedException
 */
class ThreadInterrupt extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (!isInterrupted()) {
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

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadInterrupt ti = new ThreadInterrupt();
        ti.start();
        Thread.sleep(1000);
        ti.interrupt();
        System.out.println("Main end");
    }
}