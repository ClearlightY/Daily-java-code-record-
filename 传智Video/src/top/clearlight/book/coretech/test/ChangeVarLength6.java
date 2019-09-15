package top.clearlight.book.coretech.test;

public class ChangeVarLength6 {
    public static void main(String[] args) {
        // chanVar(1, 2);
        // chanVar();
        chanVar(null);
    }

    public static void chanVar(int ... intArr) {
        System.out.println("具体参数");
    }

   /* public static void chanVar(int i, int... intArr) {
        System.out.println("可变参数");
    }*/
}
