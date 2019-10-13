package top.clearlight.bilibili.thread.feiyangedu.lock;

class ShareObject {
    final Object lockA = new Object();
    final Object lockB = new Object();

    int accountA = 1000;
    int accountB = 2000;

    public void a2b(int balance) {
        synchronized (lockA) {
            accountA -= balance;
            synchronized (lockB) {
                accountB += balance;
            }
        }
    }

    public void b2a(int balance) {
        // 更改线程的顺序将不会导致死锁
        synchronized (lockB) {
            accountB -= balance;
            synchronized (lockA) {
                accountA += balance;
            }
        }
    }
}

class AThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < DeadLock.LOOP; i++) {
            DeadLock.shared.a2b(1);
            if (i % 100 == 0) {
                System.out.println(".");
            }
        }
    }
}

class BThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < DeadLock.LOOP; i++) {
            DeadLock.shared.b2a(1);
            if (i % 100 == 0) {
                System.out.println(".");
            }
        }
    }
}

public class DeadLock {
    final static int LOOP = 1000;

    public static ShareObject shared = new ShareObject();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new AThread();
        Thread t2 = new BThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("END");
    }
}
