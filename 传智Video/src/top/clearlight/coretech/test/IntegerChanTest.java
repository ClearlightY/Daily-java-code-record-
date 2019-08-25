package top.clearlight.coretech.test;

import org.omg.CORBA.IntHolder;

public class IntegerChanTest {
    public static void main(String... args) {
        Integer i = null;
        Integer a = 1;
        // System.out.println(Integer.parseInt("a"));

        IntHolder intHolder = new IntHolder(10);
        triple(intHolder);
        System.out.println(intHolder.value);

        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(Double.NaN);
        System.out.println(Double.valueOf(0.0d / 0.0).equals(Double.NaN));
        System.out.println(0.0 / 0);
    }

    public static void triple(IntHolder intHolder) {
        intHolder.value = 2 * intHolder.value;
    }

    public static void testArr(int... value) {
        for (int i :
                value) {
            System.out.println(i);
        }
    }

    public static void testArr2(int[] a) {
        for (int i :
                a) {
            System.out.println(i);
        }
    }
}
