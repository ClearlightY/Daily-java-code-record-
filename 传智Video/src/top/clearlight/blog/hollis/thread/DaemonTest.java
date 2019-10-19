package top.clearlight.blog.hollis.thread;

/**
 *
 */
public class DaemonTest {

    public static void main(String[] args) {

        Thread t1 = new Thread();

        System.out.println(t1.isDaemon());
        t1.setDaemon(true);
        System.out.println(t1.isDaemon());
        t1.start();
        // 守护线程必须在启动线程之前调用一个线程的setDaemon()方法,
        // 否则就会抛出一个java.lang.IllegalThreadStateException
        // t1.setDaemon(false);
        System.out.println("...");

    }
}
