package cn.com.clearlight.setframe.set.bean;

import java.io.Serializable;

/**
 * Serializable : 用于给被序列化的类加入ID号.
 * 用于判断类和对象是否是同一个版本
 */
public class Person implements Serializable {
    /**
     * transient : 非静态数据不想被序列化可以使用这个关键字修饰
     */
    public static int age;
    private transient String name;
    private static final long serialVerionUID = 12435312521l;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
