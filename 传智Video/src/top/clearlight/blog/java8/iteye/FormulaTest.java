package top.clearlight.blog.java8.iteye;

import org.junit.jupiter.api.Test;

class FormulaTest {
    @Test
    public void test1() {
        Formula formula = new Formula() {
            @Override
            public double calculater(int a) {
                return sqrt(a * 100);
            }
        };

        double cal1 = formula.calculater(100);// 100
        double cal2 = formula.sqrt(10000);// 100

        System.out.println(cal1);
        System.out.println(cal2);
    }

}