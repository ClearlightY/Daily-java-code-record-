package top.clearlight.bilibili.thread.feiyangedu.build;

public class ThreadTest2 implements Runnable {
    @Override
    public void run() {
        System.out.println("hello thread");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadTest2());
        t.start();
    }
}
