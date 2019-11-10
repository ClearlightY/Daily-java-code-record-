package top.clearlight.blog.hollis.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName());

        // 第一种创建方式
        System.out.println("继承Thread类创建的线程");
        Thread t = new SubClassThread();
        t.start();

        // 第二种创建方式
        System.out.println("实现Runnable接口创建线程");
        CreateThread t2 = new CreateThread();
        new Thread(t2).start();

        // 第三种创建方式
        CallableThread callableThread = new CallableThread();
        FutureTask ft = new FutureTask(callableThread);
        new Thread(ft).start();
        // get()方法会阻塞主线程, 一直等子线程执行完成并返回后才能继续执行主线程后面的代码

        int i = 0;
        // isDone判断子线程是否执行完, call方法执行完后, 返回true
        while (!ft.isDone()) {
            // 子线程执行完执行主线程执行其他事情
            System.out.println("main" + i++);
            Thread.sleep(1000);
        }

        System.out.println(ft.get());

        System.out.println("阻塞了3s钟后," + Thread.currentThread().getName() + "继续执行");
    }
}

class SubClassThread extends Thread {
    @Override
    public void run() {
        System.out.println(getName());
    }
}

class CallableThread implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(3000);
        return "Hello Thread";
    }
}