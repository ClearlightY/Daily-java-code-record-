package top.clearlight.bilibili.thread;

import java.util.Arrays;

public class RunningTest {
    public static void main(String[] args) {
        // 1. 创建一个线程对象
        RunningMan r1 = new RunningMan("苏炳添");
        RunningMan r2 = new RunningMan("博尔特");
        RunningMan r3 = new RunningMan("加特林");
        // 2. 调用start方法,让线程进入就绪状态
        // 从Thread类中继承来的方法
        r1.start();
        r1.start();
        r1.start();

        int i = r1.addNum(2, 4);
        System.out.println(i);

        r2 = null;
        if (r2 != null) {
            System.out.println("null");
        } else {
            // System.out.println(null);
        }

        final int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr));
        int[] arr1 = new int[2];
        arr[1] = 4;
        System.out.println(Arrays.toString(arr));

    }
}
