package top.clearlight.blog.java8.iteye;

@FunctionalInterface
public interface Formula {
    double calculater(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
