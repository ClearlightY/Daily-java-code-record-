package top.clearlight.bilibili.thread.feiyangedu.build;

public class ThreadTest1 extends Thread {

    @Override
    public void run() {
        System.out.println("thread....");
    }

    public static void main(String[] args) {
        ThreadTest1 t = new ThreadTest1();
        t.start();
    }
}
