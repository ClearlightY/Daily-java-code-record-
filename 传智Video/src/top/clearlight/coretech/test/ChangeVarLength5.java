package top.clearlight.coretech.test;

public class ChangeVarLength5 {
    public static void main(String[] args) {
        chanVar(1);
        chanVar();
        chanVar(1, 2);
    }

    public static void chanVar(int intArr) {
        System.out.println("具体参数");
    }

    public static void chanVar(int... intArr) {
        System.out.println("可变参数");
    }
}
