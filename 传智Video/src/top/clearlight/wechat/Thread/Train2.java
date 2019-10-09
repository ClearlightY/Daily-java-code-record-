package top.clearlight.wechat.Thread;

public class Train2 implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        while (ticket > 0) {
            // thread.currentThread().getName() 表示当前线程名
            System.out.println(Thread.currentThread().getName() + "买票-->" + (this.ticket--));
        }
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
