package top.clearlight.wechat.Thread;

public class TrainlTest {
    public static void main(String[] args) {
        Trainl t1 = new Trainl("北京站");
        Trainl t2 = new Trainl("南京站");
        // Trainl t3 = new Trainl("河北站");
        // Trainl t4 = new Trainl("广州站");

        t1.start();
        t2.start();
        // t3.start();
        // t4.start();
    }
}
