package top.clearlight.wechat.Thread;

public class TrainTest2 {
    public static void main(String[] args) {
        Train2 t1 = new Train2();
        Thread th1 = new Thread(t1, "北京站");
        Thread th2 = new Thread(t1, "南京站");
        Thread th3 = new Thread(t1, "上海站");
        Thread th4 = new Thread(t1, "广州站");

        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
