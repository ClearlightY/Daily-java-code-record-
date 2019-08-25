package top.clearlight.coretech.test;

public class ChangeVarLength {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        chanVar(arr);
        chanVar2(arr);
        chanVar2();
        chanVar2(1);
        chanVar2(1, 2);
    }

    public static void chanVar(int[] intArr) {
        System.out.println("传入数组");
    }

    public static void chanVar2(int... intArr) {
        System.out.println("可变参数");
    }
}
