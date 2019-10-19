package top.clearlight.blog.hollis.thread;

import java.util.concurrent.TimeUnit;

public class DaemonTest2 {
    public static void main(String[] args) {
        Thread childThread = new Thread(() -> {
            while (true) {
                System.out.println("I'm child thread...");
                try {
                    // TimeUnit.MILLISECONDS.sleep(1000);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 将childThread设置为守护线程, 当用户线程执行结束后, JVM就会直接退出了.
        childThread.setDaemon(true);
        childThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I'm main thread...");
    }
}
