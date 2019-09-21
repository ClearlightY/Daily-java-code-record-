package top.clearlight.book.coretech.asserts;

import org.junit.jupiter.api.Test;

public class AssertTest {
    public static void main(String[] args) {
        // test1(-1);
    }


    @Test
    public void test1() {
        int a = -1;
        // assert b > 0;
        assert a == 0 : a;
        if (a > 0) {
            System.out.println(a);
        } else {
            System.out.println("a为负数");
        }
    }

}
