package top.clearlight.video.itheima.thread.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池 : JDK1.5之后提供的
 * java.util.concurrent.Executors : 线程池的工厂类, 用来生产线程池
 * Executors类中的静态方法:
 * <p>
 * static ExecutorService newFixedTreadPool(int nThreads)创建一个可重用固定线程数的线程池
 * 参数 :
 * int nThreads : 创建线程池中包含的线程数量
 * 返回值 :
 * ExecutorService接口, 返回的是ExecutorService接口的实现类对象, 我们可以使用ExecutorService接口接收(面向接口编程)
 * <p>
 * java.util.concurrent.ExecutorService : 线程池接口
 * 用来从线程池中获取线程, 调用start方法, 执行线程任务
 * submit(Runnable task)提交一个Runnable任务用于执行
 * 关闭/销毁线程池的方法
 * void shutdown()
 * <p>
 * 线程池的使用步骤 :
 * 1. 使用线程池的工厂类Executors里面提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
 * 2. 创建一个类, 实现Runnable接口, 重写run方法, 设置线程任务
 * 3. 调用ExecutorService中的方法submit, 传递线程任务(实现类), 开启线程, 执行run方法
 * 4. 调用ExecutorService中的方法shutdown销毁线程池(不建议执行)
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 1. 使用线程池的工厂类Executors里面提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);


        // 3. 调用ExecutorService中的方法submit, 传递线程任务(实现类), 开启线程, 执行run方法
        // 线程池会一直开启, 使用完了线程, 会自动把线程归还给线程池, 线程可以继续使用
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());

        // 4. 调用ExecutorService中的方法shutdown销毁线程池(不建议执行)
        es.shutdown();

        // java.util.concurrent.RejectedExecutionException:
        // Task java.util.concurrent.FutureTask@3498ed[Not completed, task = java.util.concurrent.Executors$RunnableAdapter@13969fbe[Wrapped task = top.clearlight.video.itheima.thread.pool.RunnableImpl@6aaa5eb0]] rejected from java.util.concurrent.ThreadPoolExecutor@1a407d53[Shutting down, pool size = 2, active threads = 2, queued tasks = 4, completed tasks = 0]
        // 线程池已经没有了, 就不能获取线程了
        // es.submit(new RunnableImpl());
    }
}
