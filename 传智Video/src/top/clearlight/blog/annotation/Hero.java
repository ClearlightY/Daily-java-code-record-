package top.clearlight.blog.annotation;

import org.junit.jupiter.api.Test;

@SuppressWarnings("deprecated")
public class Hero {

    @Deprecated
    void say() {
        System.out.println("I can speak...");
    }

    void speak() {
        System.out.println("I have a lover");
    }

    @Test
    void test() {
        Hero hero = new Hero();
        hero.say();
        hero.say();
        hero.speak();
    }
}

