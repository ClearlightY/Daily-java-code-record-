package top.clearlight.design_mode.singleton;

public class singleton_1 {
    public static void main(String[] args) {
        // Test
        Singleton instance = Singleton.getInstance();
        Singleton instance_2 = Singleton.getInstance();
        System.out.println(instance == instance_2);
        System.out.println(instance.hashCode());
        System.out.println(instance_2.hashCode());

        Singleton_2 instance_3 = Singleton_2.getInstance();
        Singleton_2 instance_4 = Singleton_2.getInstance();
        System.out.println(instance_3 == instance_4);
    }
}

// 饿汉式(静态变量)
class Singleton {

    // 1. 构造器私有化
    private Singleton() {

    }

    // 2. 本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    // 3. 提供一个公有的静态方法, 返回实例对象
    public static Singleton getInstance() {
        return instance;
    }
}

// 饿汉式(静态代码块)
class Singleton_2 {
    private static Singleton_2 instance;

    private Singleton_2() {
    }

    static {
        instance = new Singleton_2();
    }

    public static Singleton_2 getInstance() {
        return instance;
    }
}
