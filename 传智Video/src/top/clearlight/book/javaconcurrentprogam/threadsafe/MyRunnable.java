package top.clearlight.book.javaconcurrentprogam.threadsafe;

import org.junit.jupiter.api.Test;

public class MyRunnable implements Runnable {

    NotThreadSafe instance = null;

    public MyRunnable(NotThreadSafe instance) {
        this.instance = instance;
    }

    @Override
    public void run() {
        // this.instance.add("some text");
        for (int i = 0; i < 10; i++) {
            this.instance.add(1);
        }
    }

    @Test
    public void test1() {
    }

    public static void main(String[] args) throws InterruptedException {
        NotThreadSafe sharedInstance = new NotThreadSafe();

        new Thread(new MyRunnable(sharedInstance)).start();
        new Thread(new MyRunnable(sharedInstance)).start();
        new Thread(new MyRunnable(sharedInstance)).start();
        new Thread(new MyRunnable(sharedInstance)).start();

        Thread.sleep(1000);
        sharedInstance.Print();

    }
}
