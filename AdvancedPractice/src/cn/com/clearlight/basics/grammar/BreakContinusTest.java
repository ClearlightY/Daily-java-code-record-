package cn.com.clearlight.basics.grammar;

/*
    break和continue关键字的使用
    break   结束当前循环
    continue    结束当次循环
 */
public class BreakContinusTest {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 4 == 0) {
                break;
                //System.out.println("不会执行");
            }
            System.out.println(i);
        }
    }
}
