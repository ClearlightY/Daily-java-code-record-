package top.clearlight.bilibili.thread.producer;

public class TestMain {
    public static void main(String[] args) {
        Warehouse house = new Warehouse();
        Producer p = new Producer(house);
        p.setPriority(10);
        Consumer c1 = new Consumer(house);
        Consumer c2 = new Consumer(house);

        p.start();
        c1.start();
        c2.start();
    }
}
