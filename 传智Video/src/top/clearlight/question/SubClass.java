package top.clearlight.question;

public class SubClass extends SuperClass {
    static {
        System.out.println("子类 静态代码块");
    }

    public static int staticIntSub = printInt("子类 静态成员变量");

    {
        System.out.println("子类 初始代码块");
    }

    SubClass() {
        super(10);
        System.out.println("The End");
    }

    SubClass(int a) {

        System.out.println(a);
    }

    public static void main(String[] args) {
        SuperClass superClass = new SuperClass();
        System.out.println("------------------");
        SubClass subClass = new SubClass();
        System.out.println("------------------");
        SuperClass s = new SubClass();
    }
}

class SuperClass {
    int a = printInt("父类 成员变量初始化 (前)");
    {
        System.out.println("父类 初始代码块 (构造方法前)");
    }

    static {
        System.out.println("父类 静态代码块 (前)");
    }

    SuperClass() {
        System.out.println("父类 无参构造函数");
    }

    SuperClass(int a) {
        System.out.println("父类 ---- 有参构造函数");
    }

    int k = printInt("父类 成员变量初始化 (后)");

    {
        System.out.println("父类 初始代码块 (构造方法后)");
    }

    static int printInt(String s) {
        System.out.println(s);
        return 1;
    }

    public static int staticInt = printInt("父类 静态成员变量");

    static {
        System.out.println("父类 静态代码块 (后)");
    }
}