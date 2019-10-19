package top.clearlight.book.javaconcurrentprogam.sync;

class Counter {
    long count = 0;

    public synchronized void add(long count) {
        this.count += count;
    }
}

class CounterThread extends Thread {
    protected Counter counter = null;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    public /*synchronized*/ static void test() {
        synchronized (CounterThread.class) {

        }
    }

    public void doWait() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        doWait();
        for (int i = 0; i < 10; i++) {
            counter.add(1);
            System.out.println(Thread.currentThread().getName() + " : " + counter.count);
        }
    }
}

public class Example {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        Thread t1 = new CounterThread(counter);
        Thread t2 = new CounterThread(counter);

        t1.start();
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.start();
        t2.setPriority(Thread.MIN_PRIORITY);
    }
}
