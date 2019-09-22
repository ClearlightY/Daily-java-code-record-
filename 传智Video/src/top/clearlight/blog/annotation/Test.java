package top.clearlight.blog.annotation;

import java.lang.annotation.*;

@TestAnnotation
public class Test {
}

@interface Persons {
    Person[] value();
}

@Repeatable(Persons.class)
@interface Person {
    String role() default "";
}

@Person(role = "artist")
@Person(role = "coder")
@Person(role = "PM")
class SuperMan {

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TestAnnotation2 {

    int id();

    String msg() default "hhh";
}

