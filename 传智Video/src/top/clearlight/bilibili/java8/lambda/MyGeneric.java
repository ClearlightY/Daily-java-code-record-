package top.clearlight.bilibili.java8.lambda;

@FunctionalInterface
public interface MyGeneric<T, R> {
    public R oper(T t, T t1);
}
