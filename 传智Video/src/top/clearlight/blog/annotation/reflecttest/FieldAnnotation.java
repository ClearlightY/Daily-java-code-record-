package top.clearlight.blog.annotation.reflecttest;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface FieldAnnotation {
    String value();
}
