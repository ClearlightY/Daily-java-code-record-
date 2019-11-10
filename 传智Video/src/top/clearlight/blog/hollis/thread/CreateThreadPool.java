package top.clearlight.blog.hollis.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CreateThreadPool {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println("通过线程池创建线程");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
       /* threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });*/

        // 通过线程池创建线程
        threadPoolExecutor.execute(() -> System.out.println(Thread.currentThread().getName()));

    }
}
