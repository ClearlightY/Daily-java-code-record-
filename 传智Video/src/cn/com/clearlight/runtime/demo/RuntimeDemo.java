package cn.com.clearlight.runtime.demo;

import java.io.IOException;

/**
 * Runtime : 没有构造方法,说明该类不可以创建对象
 * 又发现还有非静态的方法.说明该类提供静态的返回该类对象的方法
 * 而且只有一个,说明Runtime类使用了单例设计模式
 */
public class RuntimeDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process exec = runtime.exec("notepad.exe"); // 返回一个进程
        Thread.sleep(5000);
        exec.destroy(); // 销毁该进程
    }
}
