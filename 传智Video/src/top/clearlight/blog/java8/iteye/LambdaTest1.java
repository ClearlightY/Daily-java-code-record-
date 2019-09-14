package top.clearlight.blog.java8.iteye;

import org.junit.jupiter.api.Test;

public class LambdaTest1 {

    @Test
    public void test1() {
        PersonFactory<Person> pf = Person::new;
        Person person = pf.create("Perter", "Mary");
        System.out.println(person);
    }

}
