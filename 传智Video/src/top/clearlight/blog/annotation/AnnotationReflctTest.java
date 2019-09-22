package top.clearlight.blog.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 有错误!!!!
 */
@TestAnnotation2(id = 18)
public class AnnotationReflctTest {

    @Check(value = "a value")
    public int a;

    @Perform
    public void testMethod() {
    }

    @SuppressWarnings("deprecation")
    public void test1() {
        Hero hero = new Hero();
        hero.say();
        hero.speak();
    }

    public static void main(String[] args) {
        boolean hasAnnotation = AnnotationReflctTest.class.isAnnotationPresent(TestAnnotation2.class);

        if (hasAnnotation) {
            TestAnnotation2 annotation = AnnotationReflctTest.class.getAnnotation(TestAnnotation2.class);
            // 获取类的注解
            System.out.println("id: " + annotation.id());
            System.out.println("msg: " + annotation.msg());
        }

        try {
            Field a = AnnotationReflctTest.class.getDeclaredField("a");
            a.setAccessible(true);
            // 获取一个成员变量的注解
            Check check = a.getAnnotation(Check.class);
            if (check != null) {
                System.out.println("check value: " + check.value());
            }

            Method testMethod = AnnotationReflctTest.class.getDeclaredMethod("testMethod");
            if (testMethod != null) {
                Annotation[] annotations = testMethod.getAnnotations();
                for (Annotation annotation : annotations) {
                    System.out.println("testMethod annotation: " + annotation.annotationType().getSimpleName());
                }
                /*Annotation[] ans = testMethod.getAnnotations();
                for (Annotation an : ans) {
                    if (an instanceof Perform) {
                        System.out.println(Perform.class);
                    }
                }*/
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
