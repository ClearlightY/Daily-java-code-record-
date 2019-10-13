package top.clearlight.bilibili.thread.mashibing;

public class Test4 {

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end");
    }

    public void m2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2");
    }

    public static void main(String[] args) {
        Test4 t = new Test4();

        /*new thread(() -> t.m1()).start();
        new thread(() -> t.m2()).start();*/

        new Thread(t::m1).start();
        new Thread(t::m2).start();

        /*new thread(new Runnable() {
            @Override
            public void run() {
                t.m1();
            }
        }).start();

        new thread(new Runnable() {
            @Override
            public void run() {
                t.m2();
            }
        }).start();*/
    }

}
