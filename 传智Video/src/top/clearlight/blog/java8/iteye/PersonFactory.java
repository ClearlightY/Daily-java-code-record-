package top.clearlight.blog.java8.iteye;

@FunctionalInterface
public interface PersonFactory<P extends Person> {

    P create(String firstName, String lastName);

}
