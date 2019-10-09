package top.clearlight.bilibili.thread;

public class RunningMan2 implements Runnable{
    private String name;

    public RunningMan2() {

    }
    public RunningMan2(String name) {
        this.name = name;
    }

    //重写run方法
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(this.name + "跑到第" + i + "米了");
        }
    }
}
