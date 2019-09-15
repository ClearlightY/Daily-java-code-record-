package top.clearlight.book.coretech.reflect;

class Person {
    private int i = 8;

    protected int j;

    static {
        System.out.println("Person 静态初始化子句");
    }

    {
        System.out.println("Person 实例初始化子句");
    }


    Person() {
        System.out.println("Person()");
    }

    Person(int i) {
        System.out.println("Person(int), i=" + i);
    }

    int k = printInit("Person.k 初始化");

    static int m = printInit("static Person.m 初始化");

    {
        System.out.println("Person 后置实例初始化语句");
    }

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }

}

public class Student extends Person {

    Student() {
        super(1);
        System.out.println("Student()");
    }

    Student(int i) {
        this();
        System.out.println("Student(int), i=" + i);
    }

    public static void main(String[] args) {
        new Person(3);
        System.out.println("--------------------------");
        Student student = new Student(2);
    }

    static {
        System.out.println("Student 静态初始化子句");
    }

    public static int marker = printInit("Student.marker 初始化");

    {
        System.out.println("Student 实例初始化域");
    }


}