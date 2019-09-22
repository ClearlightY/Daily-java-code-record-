package top.clearlight.blog.annotation.reflecttest;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Container.class)
public @interface Person {
    String role() default "artist";
}
