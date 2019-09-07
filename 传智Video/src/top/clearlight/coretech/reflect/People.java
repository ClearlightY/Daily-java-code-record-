package top.clearlight.coretech.reflect;

import java.util.ArrayList;
import java.util.List;

public class People extends Animal implements Comparable<People>{
    private String name;
    public int age;
    static String sex;

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public People() {
    }

    public People(String name) {
        this.name = name;
    }

    private People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(People o) {
        return Double.compare(this.age, o.age);
    }

    @Override
    public void move() {
        System.out.println("行走");
    }

    @Override
    void shout() {
        System.out.println("交流");
    }

    public List<String> getStringList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("hhhh");
        return list;
    }
}
