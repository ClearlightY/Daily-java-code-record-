package top.clearlight.grammer;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal m = new BigDecimal("1.255533");
        BigDecimal n = m.setScale(3, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(n);// 1.255

        BigDecimal bd = new BigDecimal(0.1f);
        System.out.println(bd);
        BigDecimal bd1 = new BigDecimal("0.1");
        System.out.println(bd1);
        BigDecimal bd2 = BigDecimal.valueOf(0.1);
        System.out.println(bd2);
        int a;
        a = 1+2;
        System.out.println(a);
    }
}
