package top.clearlight.book.coretech.test;

public class ChangeVarLength4 {
    public static void main(String[] args) {
        changePara();
        changePara(1);
        changePara(1, 2);
    }

    public static void changePara(Object... obj) {
        for (Object o : obj) {
            System.out.println(o);
        }
    }
}
