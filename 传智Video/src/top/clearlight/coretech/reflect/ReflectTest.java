package top.clearlight.coretech.reflect;

import java.lang.reflect.Constructor;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        // "PriConstructO' has private access in ' top. clearlight. coretech. reflect. PriConstruct'
        // PriConstruct pri = new PriConstruct();

        // 创建私有 无参 构造器的类对象的方式
        Constructor<PriConstruct> dc = PriConstruct.class.getDeclaredConstructor();
        dc.setAccessible(true);
        PriConstruct pri = dc.newInstance();
        System.out.println("Constructor对象创建私有无参构造器类的对象 : " + pri.toString());

        // 创建私有 有参 构造器的类对象的方式
        Constructor<PriConstruct> dc2 = (Constructor<PriConstruct>) Class.forName(PriConstruct.class.getName()).getDeclaredConstructor(String.class, int.class);
        dc2.setAccessible(true);
        PriConstruct pri2 = dc2.newInstance("Marry", 17);
        System.out.println("Constructor对象创建私有有参构造器类的对象 : " + pri2.toString());

        System.out.println("----------------------------");

        // 创建对象的第一种方式
        PubConstruct pub = new PubConstruct();
        System.out.println("new方式构造的对象 : " + pub.toString());
        // 创建对象的第二种方式
        PubConstruct pubConstruct1 = pub.getClass().newInstance();
        System.out.println("对象.getClass().newInstance()方式构造的对象 : " + pubConstruct1.toString());
        // 创建对象的第三种方式
        PubConstruct pubConstruct = (PubConstruct) Class.forName(PubConstruct.class.getName()).newInstance();
        System.out.println("Class.forName(全限定类名).newInstance()方式2构造的对象 : " + pubConstruct.toString());

        // 创建对象的第四种方式
        PubConstruct pubConstruct2 = PubConstruct.class.newInstance();
        System.out.println("类名.class.newInstance()方式创建对象 : " + pubConstruct2.toString());

        Constructor<?> pubCon = Class.forName("top.clearlight.coretech.reflect.PubConstruct").getConstructor();
        pubCon.setAccessible(true);
        PubConstruct pubConstruct3 = (PubConstruct) pubCon.newInstance();
        System.out.println("Constructor类创建公有无参构造函数 : " + pubConstruct3.toString());

        Integer integer = Integer.class.getConstructor(int.class).newInstance(10);
        System.out.println(integer);
        //System.out.println(integer);
        Class<Integer> integerClass = Integer.class;
    }
}

class PriConstruct {
    private String name;
    private int age;

    private PriConstruct() {
    }

    private PriConstruct(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "PriConstruct{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class PubConstruct {
    private int age;

    public PubConstruct() {
    }

     PubConstruct(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "公有的构造器的类";
    }
}