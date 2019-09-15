package top.clearlight.book.coretech.test;

import java.util.Random;

public class ChangeVarLength2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
      String[] strArr = {"hello"};
       //  向上转型
       /* Base base = new Sub();
        base.print(strArr);

        // 不转型
       Sub sub = new Sub();*/
        //sub.print("hello");
        //Class c1 = base.getClass();
       // System.out.println(c1.getName());
        String className = "java.util.Random";
        Object o= Class.forName(className).newInstance();
        // System.out.println(c2.getName());
        Random o1 = (Random) o;
        int i = o1.nextInt(10);
        System.out.println("i = " + i);

        Class c3 = double[].class;
        System.out.println(c3.getName());


        // 通过反射创建Base类的对象
        Base b = (Base) (Class.forName("top.clearlight.book.coretech.test.Base").newInstance());
        b.print("hello");

        Base b2 = new Base();
        Base b3 = b2.getClass().newInstance();
        b2.print("a");
        b3.print("b");
    }
}

// 基类
class Base {
    public Base() {
    }

    void print(String ... args) {
        System.out.println("Base......test");
    }
}

// 子类，覆写父类方法
/*class Sub extends Base {
    @Override
    void print(String[] args) {
        System.out.println("Sub......test");
    }
}*/
