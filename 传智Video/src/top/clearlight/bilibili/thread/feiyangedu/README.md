**源出处 : [Java教程 多线程 - 廖雪峰](https://www.bilibili.com/video/av54953654/?p=1)**

# 一、中断线程

通过调用interrupt方法来中断线程,isInterrupt来获取当前线程是否已中断,true表示线程中断
如果线程处于等待状态, 该线程会捕获InterruptedException

# 二、守护线程
## 1.setDaemon方法
**如何变为守护线程?**

想要变为守护线程的线程通过调用setDaemon方法并设置为true即可.

```
public final void setDaemon​(boolean on)
将此线程标记为daemon线程或用户线程。 当运行的唯一线程都是守护进程线程时，Java虚拟机将退出。
线程启动前必须调用此方法。

参数
on - 如果是 true ，将此线程标记为守护线程
异常
IllegalThreadStateException - 如果这个线程是 alive
SecurityException - 如果 checkAccess()确定当前线程不能修改此线程
```

## 2.守护线程的特点
 * 守护线程是为其他线程服务的线程
 * 所有非守护线程都执行完毕后, 虚拟机退出
 * 守护线程不能持有资源(如打开文件等)

# 三、同步问题

## 1.synchronized的问题
性能下降(无法同步进行, 加锁以及释放锁会消耗时间)

**如何使用synchronized:**
1. 找到修改共享变量的代码块
2. 选择一个实例作为锁
3. 使用synchronized(lockObject) {...}

## 2.JVM规范定义了几种原子操作(不需要同步)
* 基本类型(long和double除外)赋值:
    
    int n = 100;
* 引用类型赋值

    List<String> list = anotherList;
    
## 3.同步问题
1. 原子操作不需要同步
2. 把非原子操作变为原子操作
3. 局部变量不需要同步.(变量以及方法参数都是局部变量, 各个线程的局部变量是完全独立的互不影响,不需要同步)

**多线程同时修改变量, 会造成逻辑错误:**
* 需要通过synchronized同步
* 同步的本质就是给指定对象家所
* 注意加锁对象必须是同一个实例
* 对JVM顶一个单个原子操作不需要同步

## 4.线程安全的类
- 不变类 : String, Integer, LocalDate
- 没有成员变量的类 : Math
- 正确使用synchronized的类 : StringBuffer

## 5.非线程安全的类
- 不能在多线程中共享实例并修改 : ArrayList
- 可以在多线程中以只读的方式共享它们

## 6.synchronized总结
- 用synchronized修饰方法可以把整个方法变为同步代码块
- synchronized方法加锁对象是this
- 通过合理的设计和数据封装可以让一个类变为"线程安全"
- 一个类没有特殊说明, 默认不是 thread-safe
- 多线程能否访问某个非线程安全的实例, 需要具体问题具体分析

# 四、死锁
- java的线程锁是可重入的锁
```java
public class Test {
    public void add(int m) {
        synchronized(lock) {
            this.value += m;
            synchronized(lock) {
                this.anthoer += m;
            } 
        }
    }
}
```
- java的线程可以获取多个不同对象的锁
```java
public class Test{
    public void add(int m) {
        // 获得lockA的锁
        synchronized (lockA) {
            this.value += m;
            // 获得lockB的锁
            synchronized (lockB) {
                this.another += m;
            } // 释放lockB的锁
        } // 释放lockA的锁
    }
}
```
## 1.死锁产生的条件

多线程各自持有不同的锁， 并互相试图获取对方已持有的锁

\
不同线程获取多个不同对象的锁可能导致死锁

**线程1**
```java
public class A {
    public void add(int m) {
        synchronized (lockA) {
            this.value += m;
            synchronized (lockB) {
                this.another += m;
            }
        }
    }
}
```

**线程2**
```java
public class B {
    public void dec(int m) {
        synchronized (lockB) {
            this.another -= m;
            synchronized (lockA) {
                this.value -= m;
            }
        }
    }
}
```

死锁发生后 :
- 没有任何机制能解除死锁
- 只能强制结束JVM进程   

## 2.如何避免死锁

多线程获取锁的顺序要一致

# 五、wait/notify机制

调用wait方法时, 线程会释放它获得的锁! wait方法返回后, 线程重新获得this锁.

notify方法来唤醒在this方法上正在等待的线程. 这样wait方法就被唤醒, wait返回以后, 继续执行.

**总结**
- 在synchronized内部可以调用wait()使线程进入等待状态
- 必须在已获得的锁对象上调用wait()方法
- 在synchronized内部可以调用notify/notifyAll()唤醒其他等待线程
- 必须在已获得的锁对象上调用notify/notifyAll()方法

# 六、java.util.concurrent包

- 简化多线程程序的编写
- JDK >= 1.5

## 1. java.util.locks.ReentrantLock

**可以替代synchronized加锁:**
```java
class Counter{
    public void inc() {
        synchronized(lockObj) {
            n = n + 1;
        }
    }
}
```

```java
import java.util.concurrent.locks.ReentrantLock;
class Counter {
    final Lock lock = new ReentrantLock();
    public void inc() {
        lock.lock();
        try {
            n = n + 1;
        } finally {
            lock.unlock();
        }
    }
}
```
**ReentrantLock**
- 可重入锁, 一个线程可多次获取同一个锁
- lock()方法可获取锁
- tryLock()方法可尝试获取锁并可指定超时
```java
import java.util.concurrent.TimeUnit;import java.util.concurrent.locks.ReentrantLock;
class Counter {
    final Lock lock = new ReentrantLock();
    public void inc() {
        if (lock.tryLock(1, TimeUnit.SECONDS)){
            try{
                n = n + 1;
            } finally{
                lock.unlock();
            }
        }
    }
}
```
**总结**
- ReentrantLock可以替代synchronized
- ReentrantLock获取锁更安全
- 必须使用try...finally 保证正确获取和释放锁

## 2.ReadWriteLock

**适用条件**
同一个实例, 有大量线程读取, 仅有少数线程修改(eg.帖子)

**使用方法**
```java
class Counter1 {
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    private Lock rlock = lock.readLock();
    private Lock wlock = lock.writeLock();

    private int value = 0;

    public void add(int m) {
        wlock.lock();
        try {
            this.value += m;
        } finally {
            wlock.unlock();
        }
    }
    
    public int get() {
        rlock.lock();
        try{
            return this.value;
        } finally{
            rlock.unlock();
        }
    }
}
```

允许多个线程同时读, 但只要有一个线程写, 其他线程就必须等待

**总结**
使用ReadWriteLock可以提高读取效率
- ReadWriteLock只允许一个线程写入
- ReadWriteLock允许多个线程同时读取
- ReadWriteLock适合读多写少的场景

## 3.Condition事件
Condition.await/signal/signalAll原理和wait/notify/notifyA一致
- await()会是释放当前锁, 进入等待状态
- signal()会唤醒某个等待线程
- signalAll()会唤醒所有等待线程
- 唤醒线程从await()返回后需要重新获得锁才可以继续向下执行

**总结**
- Condition可以替代wait/notify
- Condition对象必须从ReentrantLock对象获取
- ReentrantLock+Condition(await/signal) 可以替代 synchronized+wait/notify

## 4.Blocking集合

Interface|Non-thread safe|Thread safe
---|---|---
List|ArrayList|CopyOnWriteArrayList
Map|HashMap|ConcurrentHashMap
Set|HashSet,TreeSet|CopyOnWriteArraySet
Queue|ArrayDeque,LinkedList|ArrayBlockingQueue,LinkedBlockingQueue
Deque|ArrayDeque,LinkedList|LinkedBlockingDeque

**总结**
使用java.util.concurrent提供的Blocking集合可以简化多线程编程
- 多线程同事访问Blocking集合是安全的
- 尽量使用JDK提供的concurrent集合, 避免自己编写同步代码

## 5.atomic原子操作

可以简化多线程编程:
- AtomicInteger/AtomicLong/AtomicIntegerArray等
- 原子操作实现了无锁的线程安全
- 适用于计数器,累加器等

# 七、线程池
- 线程池维护若干个线程, 处于等待状态
- 如果有新任务, 就分配一个空闲线程执行
- 如果所有线程都处于忙碌状态, 新任务放入队列等待

ScheduledThreadPool: 一个任务可以定期反复执行
- Fixed Rate : 每隔指定时间任务就会启动,而不管这个任务执行多长时间
- Fixed Delay : 无论任务执行多久, 只有在任务结束之后, 等待一秒钟, 才会开始执行下一次的任务

java.util.Timer
- 一个Timer对应一个Thread
- 必须在主线程结束时调用Timer.cancel()

**总结**
- jdk提供了ExecutorService实现了线程池功能
- 线程池内部维护一组线程, 可以高效执行大量小任务
- Executors提供了静态方法创建不同类型的ExecutorService
- 必须调用shutdown()关闭ExecutorService
- ScheduledThreadPool可以定期调度多个任务

## Future
Runnable & Callable :

不需要返回结果|需要返回结果
---|---
Runnable|Callable

提交Callable任务,可以获得一个Future对象, 然后调用get方法可以在将来某个时刻获取结果.

- 阻塞方法: get()
- 轮询: isDone()

CompletableFuture基本用法:

CompletableFuture<String> cf = CompletableFuture.supplyAsync(异步执行实例);
cf.thenAccept(获得结果后的操作);
cf.exceptionally(发生异常时的操作);

多个CompletableFuture可以串行执行:

CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(异步执行实例1);

CompletableFuture<LocalData> cf2 = cf1.thenApplyAsync(异步执行实例2);

CompletableFuture<Float> cf3 = cf2.thenApplyAsync(异步执行实例3);

cf3.thenAccept(实例3获得结果后的操作);

**CompletableFuture总结**
- thenAccept()处理正常结果
- exceptional()处理异常结果
- thenApplyAsync()用于串行化里一个CompletableFuture
- anyOf/allOf用于并行化两个CompletableFuture