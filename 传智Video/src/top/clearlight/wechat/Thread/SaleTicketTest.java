package top.clearlight.wechat.Thread;

public class SaleTicketTest {
    public static void main(String[] args) {
        SaleTicket s1 = new SaleTicket();
        Thread t1 = new Thread(s1, "北京站");
        Thread t2 = new Thread(s1, "南京站");
        Thread t3 = new Thread(s1, "广州站");
        Thread t4 = new Thread(s1, "深圳站");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
