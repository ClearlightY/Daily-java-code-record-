package top.clearlight.bilibili.thread.feiyangedu.syn;

class Counter {
    int count = 0;

    public synchronized void add(int n) {
        count += n;
    }

    public synchronized void dec(int n) {
        count -= n;
    }

    /**
     * 获取的count是int类型的值,属于原子操作,所以不用加synchronized
     *
     * @return count的值
     */
    public int get() {
        return count;
    }
}

class AddThread2 extends Thread {
    Counter counter;

    public AddThread2(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int i = 0; i < SynMethod.LOOP; i++) {
            counter.add(1);
        }
    }
}

class DecThread2 extends Thread {
    Counter counter;

    public DecThread2(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < SynMethod.LOOP; i++) {
            counter.dec(1);
        }
    }
}

public class SynMethod {
    final static int LOOP = 10000;

    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        AddThread2 t1 = new AddThread2(c);
        DecThread2 t2 = new DecThread2(c);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c.get());
    }
}
