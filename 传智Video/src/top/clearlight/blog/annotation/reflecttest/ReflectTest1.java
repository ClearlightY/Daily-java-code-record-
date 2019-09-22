package top.clearlight.blog.annotation.reflecttest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

// @MyAnnotation(msg = "type annotation", id = 1)
public class ReflectTest1 extends SuperClass{
    @FieldAnnotation(value = "file annotation")
    private int age;

    @Person(role = "student")
    @Person(role = "cooker")
    @Person(role = "superman")
    public void test() {
        System.out.println("用来测试Repeatable注解");
    }

    @MyAnnotation(id = 4)
    public void test2() {
        System.out.println("直接获取多个方法的注解");
    }

    public static void main(String[] args) {
        Class<ReflectTest1> rt = ReflectTest1.class;

        // 获得的父类的类注解,该注解已经通过@Inherited修饰
        System.out.println("获取类注解");
        Annotation[] typeAns = rt.getAnnotations();
        for (Annotation typeAn : typeAns) {
            if (typeAn instanceof MyAnnotation) {
                MyAnnotation man = (MyAnnotation) typeAn;
                System.out.println("msg(): " + man.msg());
                System.out.println("id(): " + man.id());
            }
        }

        // 获取的字段的注解
        System.out.println("\n获取字段注解");
        try {
            Field age = rt.getDeclaredField("age");
            // 访问private修饰的字段, 需要修改访问权限
            age.setAccessible(true);
            // 获得指定的注解
            FieldAnnotation fieldAn = age.getAnnotation(FieldAnnotation.class);
            if (fieldAn != null) {
                System.out.println("字段的value(): " + fieldAn.value());
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        // 获取通过@Repeatable修饰的方法的注解,
        System.out.println("\n获取方法注解");
        Method[] methodsAns = rt.getDeclaredMethods();
        for (Method methodsAn : methodsAns) {
            Annotation[] ans = methodsAn.getAnnotations();
            for (Annotation an : ans) {
                System.out.println(an);
            }
        }

        // 获取指定方法的注解
        System.out.println("\n获取指定方法的注解");
        try {
            Method test = rt.getDeclaredMethod("test", null);
            Container conAn = test.getAnnotation(Container.class);
            System.out.println("人的角色: ");
            for (Person person : conAn.value()) {
                System.out.println(person.role());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
