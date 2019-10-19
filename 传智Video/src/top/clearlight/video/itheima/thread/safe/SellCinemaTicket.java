package top.clearlight.video.itheima.thread.safe;

/**
 * 解决线程安全的三种方法
 * 1. 使用同步代码块
 * 2. 使用同步方法
 * 3. 使用Lock锁
 */
public class SellCinemaTicket implements Runnable{
    private int ticket = 100;

    // 同步方法
    @Override
    public /*synchronized*/ void run() {
        System.out.println("this :" + this);
        while (true) {
           payTicket();
        }
    }

    Object obj = new Object();

    // 同步代码块
    public  void payTicket() {
        synchronized (obj) {
            if (ticket > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + ticket--);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new SellCinemaTicket();

        System.out.println(r);

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t1.join();
        t2.start();
        // t2.join();
        // t3.start();
        // t3.join();
        System.out.println("Main end");
    }
}
