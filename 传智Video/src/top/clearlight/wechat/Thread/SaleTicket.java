package top.clearlight.wechat.Thread;

public class SaleTicket implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                // 修饰代码块,锁住一个临界资源
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName()
                            + " 售出1张票, 还有余票:" + --ticket);
                } else {
                    System.out.println(Thread.currentThread().getName()
                            + "现在没有票了!!!");
                    break;
                }
            }
            try { // 如果放在循环外不会出现连续买票
                // 休眠
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
