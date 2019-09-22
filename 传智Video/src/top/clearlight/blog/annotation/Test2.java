package top.clearlight.blog.annotation;

import java.lang.annotation.Annotation;

@TestAnnotation2(id = 3)
public class Test2 {
    public static void main(String[] args) {
        // isAnnotationPresent : 判断它是否应用了某个注解
        boolean hasAnnotation = Test2.class.isAnnotationPresent(TestAnnotation2.class);

        if (hasAnnotation) {
            // getAnnotation : 获取Annotation对象
            TestAnnotation2 testAnnotation2 = Test2.class.getAnnotation(TestAnnotation2.class);

            System.out.println("id: " + testAnnotation2.id());
            System.out.println("msg: " + testAnnotation2.msg());

            Annotation[] annotations = Test2.class.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
        }
    }
}