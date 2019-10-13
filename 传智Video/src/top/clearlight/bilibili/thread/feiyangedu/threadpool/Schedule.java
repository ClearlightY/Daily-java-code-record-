package top.clearlight.bilibili.thread.feiyangedu.threadpool;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class HelloTask implements Runnable {
    String name;

    public HelloTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Hello, " + name + "! It is " + LocalTime.now());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("GoodBye, " + name + "! It is " + LocalTime.now());
    }
}

public class Schedule {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        executor.scheduleAtFixedRate(new HelloTask("Bob"), 2, 5, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(new HelloTask("Alice"), 2, 5, TimeUnit.SECONDS);
    }
}
