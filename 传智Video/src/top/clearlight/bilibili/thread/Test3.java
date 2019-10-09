package top.clearlight.bilibili.thread;

/**
 * 分析该程序的输出
 */
public class Test3 implements Runnable {
   private int count = 10;

   @Override
   public synchronized void run() {
       count--;
       System.out.println(Thread.currentThread().getName() + " count" + count);
   }

    public static void main(String[] args) {
        Test3 t = new Test3();
        // 多个线程去访问一个对象, 如果不加锁的话, 有可能其中一个线程还没有
        for (int i = 0; i < 100; i++) {
            new Thread(t, "THREAD" + i).start();
        }

    }

}
