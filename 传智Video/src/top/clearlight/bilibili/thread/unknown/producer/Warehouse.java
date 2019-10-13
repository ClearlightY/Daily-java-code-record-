package top.clearlight.bilibili.thread.unknown.producer;

import java.util.ArrayList;

public class Warehouse {

    // 单利设计模式

    // 仓库里面的集合 存放元素
    private ArrayList<String> list = new ArrayList<>();

    // 向集合内添加元素的方法
    public void add() {
        synchronized (this) {
            if (list.size() < 20) {
                list.add("a");
            } else {
                // 让方法执行到这里结束方法
                // return;
                try {
                    this.notifyAll();
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 从集合内获取元素的方法
    public void get() {
        synchronized (this) {
            if (list.size() > 0) {
                list.remove(0);
            } else {
                // return;
                try {
                    this.notifyAll();
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
