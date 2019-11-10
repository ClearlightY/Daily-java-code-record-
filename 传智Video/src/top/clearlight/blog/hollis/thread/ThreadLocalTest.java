package top.clearlight.blog.hollis.thread;

/**
 * 源码来自网站 : [ThreadLocal的简单使用及实现的原理](https://baijiahao.baidu.com/s?id=1609916413785756020&wfr=spider&for=pc&isFailFlag=1)
 *
 * ThreadLocal有四个方法, 分别为:
 * initialValue : 返回此线程局部变量的初始值
 * get : 返回此线程局部变量的当前线程副本中的值. 如果这是线程第一次调用该方法, 则创建并初始化此副本
 * set : 将此线程局部变量的当前线程副本中的值设置为指定值. 许多应用程序不需要这项功能, 它们只依赖于initialValue()方法来设置线程局部变量的值
 * remove : 移除此线程局部变量的值
 *
 */
class Bank{
    ThreadLocal<Integer> t = new ThreadLocal<>(){
        // 重写里面的方法就可以修改初始值
        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    public int get() {
        return t.get();
    }

    public void set() {
        // 获得值
        t.set(t.get() + 10);
    }

}

class Transfer implements Runnable {

    Bank bank;

    public Transfer(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            bank.set();
            // 输出不同线程的ThreadLocal的值
            System.out.println(Thread.currentThread().getName() + " : " + bank.get());
        }
    }
}

public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        // 多个线程都是同时操作一个变量, 但是不同线程的结果是互不影响的
        Transfer t = new Transfer(bank);
        Thread t1 = new Thread(t);
        t1.start();
        Thread t2 = new Thread(t);
        t2.start();
        t1.join();
        t2.join();
        // 需要注意的是, 这个是main()线程中的变量, 输出的ThreadLocal<Integer> t的初始值, 也就是100
        System.out.println(bank.get());
    }
}

