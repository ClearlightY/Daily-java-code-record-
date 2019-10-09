package top.clearlight.bilibili.thread.producer;

public class Consumer extends Thread {

    private Warehouse house;

    public Consumer(Warehouse house) {
        this.house = house;
    }

    // 消费者的方法 一直从仓库内获取元素
    @Override
    public void run() {
        while (true) {
            house.get();
            System.out.println("消费者拿走了一件货物");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
