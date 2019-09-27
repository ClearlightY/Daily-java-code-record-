package top.clearlight.question;

/**
 * 创建的匿名对象是子类对象还是父类对象呢?
 */
public class PloyAnonyTest extends Super {
    @Override
    public void m() {
        System.out.println("Sub method");
    }

    public void subM() {
        System.out.println("only in sub");
    }

    public static void main(String[] args) {
        Super s = new PloyAnonyTest();
        s.m();
        s.superM();
        // 下面代码将会报错 : 指向子类的父类没有subM()方法
        // s.subM();

        PloyAnonyTest ployAnonyTest = new PloyAnonyTest();
        ployAnonyTest.superM();
        ployAnonyTest.subM();
        // 这里可以可以看出,默认匿名创建对象调用的是子类对象.
        new PloyAnonyTest().subM();
    }
}

class Super {
    public void m() {
        System.out.println("Super method");
    }

    public void superM() {
        System.out.println("only in super");
    }
}