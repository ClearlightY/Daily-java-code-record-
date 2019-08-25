package top.clearlight.bilibili.Thread;

public class RunningTest2 {
    public static void main(String[] args) {
        // 1. 创建一个线程对象
        RunningMan2 r1 = new RunningMan2("苏炳添");
        RunningMan2 r2 = new RunningMan2("博尔特");
        RunningMan2 r3 = new RunningMan2("加特林");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        // 2. 调用start方法,让线程进入就绪状态
        t1.start();// 从thread类中继承来的方法
        t2.start();
        t3.start();
    }
}
