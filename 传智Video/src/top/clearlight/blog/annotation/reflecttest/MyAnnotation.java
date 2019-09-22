package top.clearlight.blog.annotation.reflecttest;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAnnotation {

    String msg() default "hhhh";

    int id() default 0;
}
