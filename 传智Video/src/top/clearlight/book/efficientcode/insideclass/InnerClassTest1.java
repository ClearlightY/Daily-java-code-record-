package top.clearlight.book.efficientcode.insideclass;

public class InnerClassTest1 {

    // 成员内部类
    private class InstanceInnerClass {

    }

    // 静态内部类
    static class StaticInnerClass {

    }

    static int a = 1;

    public static void main(String[] args) {
        // 两个匿名内部类
        (new Thread() {}).start();
        (new Thread() {}).start();

        // 两个方法内部类
        class MethodClass {
        }
        class MethodClass2 {
        }
    }
}
