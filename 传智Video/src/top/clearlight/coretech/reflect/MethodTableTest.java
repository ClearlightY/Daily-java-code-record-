package top.clearlight.coretech.reflect;

import java.lang.reflect.Method;

/**
 * 调用任意方法
 */
public class MethodTableTest {
    public static void main(String[] args) throws NoSuchMethodException {
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        // print tables of x- and y-values
        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }

    public static double square(double x) {
        return x * x;
    }

    private static void printTable(double from, double to, int n, Method f) {
        System.out.println(f);

        double dx = (to - from) / (n - 1);
        System.out.println(dx);
        for (double x = from; x <= to; x += dx) {
            try {
                // invoke方法，允许调用包装在当前Method对象中的方法
                double y = (Double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n", x, y);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
