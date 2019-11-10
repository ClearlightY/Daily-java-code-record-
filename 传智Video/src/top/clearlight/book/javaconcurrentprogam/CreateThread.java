package top.clearlight.book.javaconcurrentprogam;

import org.junit.jupiter.api.Test;

/**
 * 创建线程的两种方式,继承Thread或者实现Runnable接口
 * 推荐第二种,因为线程池可以有效的管理实现了Runnable接口的线程,如果线程池满了, 新的线程就会排队等候执行,
 * 直到线程池空闲出来为止.
 * <p>
 * 融合实现Runnable接口和Thread子类两种方式.
 * eg: 实现了Thread子类的实例可以执行多个实现了Runnable接口的线程.一个典型的应用就是线程池.
 */
public class CreateThread {
    public static void main(String[] args) {
        System.out.println("Main thread name is " + Thread.currentThread().getName());
        new Thread(() -> {
            System.out.println("this is " + Thread.currentThread().getName());
        }).start();
        System.out.println("Main thread is over");
    }

    @Test
    public void test6() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println("Thread: " + Thread.currentThread().getName() + "running");
            }, "" + i).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void test5() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            new Thread("" + i) {
                @Override
                public void run() {
                    System.out.println("Thread: " + getName() + "running");
                }
            }.start();
        }
    }

    @Test
    public void test4() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "New Thread").start();
    }

    @Test
    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable thread " + Thread.currentThread().getName());
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

    @Test
    public void test2() {
        Runnable r = () -> {
            System.out.println("Runnable thread " + Thread.currentThread().getName());
        };
        new Thread(r).start();
    }

    @Test
    public void test3() {
        new Thread(() -> {
            System.out.println("Runnable thread " + Thread.currentThread().getName());
        }).start();
    }

}
