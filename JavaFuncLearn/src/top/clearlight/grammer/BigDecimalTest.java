package top.clearlight.grammer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal m = new BigDecimal("1.255533");
        BigDecimal n = m.setScale(3, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(n);// 1.256

        BigDecimal bd = new BigDecimal(0.1f);
        System.out.println(bd);
        BigDecimal bd1 = new BigDecimal("0.1");
        System.out.println(bd1);
        BigDecimal bd2 = BigDecimal.valueOf(0.1);
        System.out.println(bd2);
        int a;
        a = 1+2;
        System.out.println(a);

        String str = "0.61905";
        Double double1 = Double.parseDouble(str);
        BigDecimal b = new BigDecimal(double1);
        double f1 = b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);

        // long num = Math.round(double1*10000);
        // System.out.println(num);

        System.out.println(roundString(double1, 4));

    }

    /**
     * 提供精确的小数位四舍五入处理,显示指定格式数字。
     *
     * @param d
     *            需要四舍五入的数字
     * @param scale
     *            小数点后保留几位
     * @return (string型) 四舍五入后的结果
     */
    public static String roundString(double d, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(d));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).toString();
    }

}
