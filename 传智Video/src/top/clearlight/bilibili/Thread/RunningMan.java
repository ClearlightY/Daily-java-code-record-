package top.clearlight.bilibili.Thread;

public class RunningMan extends Thread {
    private String name;
    private int a = 3;

    public RunningMan() {

    }
    public RunningMan(String name) {
        this.name = name;
    }

    //重写run方法
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(this.name + "跑到第" + i + "米了");
        }
    }

    public int addNum(int x, int y) {
        return add(x, y);
    }

    private int add(int x, int y) {
        int b = 2;
        System.out.println(a);
        return x + y;
    }
}
