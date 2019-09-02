package top.clearlight.coretech.reflect;

public class People {
    private String name;
    int age;

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
}
