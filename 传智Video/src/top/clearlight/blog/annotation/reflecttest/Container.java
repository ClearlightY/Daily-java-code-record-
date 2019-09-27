package top.clearlight.blog.annotation.reflecttest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Container {
    Person[] value();
}
