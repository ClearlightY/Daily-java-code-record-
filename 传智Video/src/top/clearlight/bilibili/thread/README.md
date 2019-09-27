# 学习地址
[马士兵Java高并发编程](https://www.bilibili.com/video/av33688545)

# 思考
1. 如何模拟死锁

    理论: 创建两个线程和两个被synchronized修饰的方法, 第一个线程调用方法A然后在调用方法B,第二个线程先调用方法B在调用方法A.
这是当第一个线程调用方法B的时候已经被第二个线程锁住, 同理,当第二个线程调用A的时候已经被第一个线程锁住.
2. 线程抛出异常会自动释放锁吗?

    如果使用的是synchronized加的锁, 加锁的过程中出现异常会自动释放,如果不想释放锁,就加上try-catch捕获这个异常,做出正确的处理
    如果是手动锁, 出异常不会释放锁.

3. volatile和synchronized区别?
   
   volatile只保证可见性, 不保证原子性;而synchronized既保证可见性, 又保证原子性
   synchronized比volatile的效率低,所以只需要保证可见性的话,使用volatile
   
 4. wait释放锁, sleep和notify不释放锁.
 
    notify是唤醒对象的某一个线程, 而notifyAll是唤醒对象的所有线程
    
 5. synchronized锁定的是?
 
    对象, 如果给方法加上synchronized的话, 锁定的为this; 如果这个方法用static修饰, 那么锁定的是类.class
    
 6. synchronized与ReentrantLock的区别 
  
    - 可以完成synchronized的功能, 可以替代syn
    - 比syn灵活, 可以使用tryLock尝试锁定, 根据锁定的结果来执行相应的代码逻辑; tryLock还可以指定时间, 规定时间内锁定不了, 就进行自己的处理
    - 还可以使用lockInterruptibly()方法对interrupt()方法作出响应,完成打断一直等待的线程
    - 还可以指定公平锁, 谁等待的时间长, 谁优先得到锁.
   
   
   

