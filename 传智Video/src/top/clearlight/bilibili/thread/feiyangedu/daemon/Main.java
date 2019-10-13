package top.clearlight.bilibili.thread.feiyangedu.daemon;

import java.time.LocalTime;

/**
 * 守护线程是为其他线程服务的线程
 * 所有非守护线程都执行完毕后, 虚拟机退出
 * 守护线程不能持有资源(如打开文件等)
 */
class TimerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main start");
        TimerThread t = new TimerThread();
        // 将t线程变为守护线程
        t.setDaemon(true);
        t.start();
        Thread.sleep(5000);
        System.out.println("Main end");
    }
}
