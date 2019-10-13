package top.clearlight.bilibili.thread.feiyangedu.threadpool;

import java.util.concurrent.*;

class PrintTask implements Runnable {
    String name;

    public PrintTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Hello, " + name + "!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        // 动态根据任务提供线程
        // ExecutorService executor = Executors.newCachedThreadPool();
        // 提供单个线程
        // ExecutorService executor = Executors.newSingleThreadExecutor();
        // 提供指定的线程数量
        // ExecutorService executor = Executors.newFixedThreadPool(3);
        ExecutorService executor = new ThreadPoolExecutor(0, 10,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        executor.submit(new PrintTask("Bob"));
        executor.submit(new PrintTask("Alice"));
        executor.submit(new PrintTask("Jack"));
        executor.submit(new PrintTask("Tim"));
        Thread.sleep(8000);
        executor.shutdown();

    }
}
