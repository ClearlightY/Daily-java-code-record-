package top.clearlight.blog.sugar;

public class AssertSugar {
    public static void main(String[] args) {
        /*int a = 1;
        int b = 1;
        assert a != b;
        System.out.println("乘风破浪");
        assert a == b : "Clearlight";
        System.out.println("网址 : www.clearlight.top");*/


        Integer i = 100;

        Integer j = new Integer(100);

        int m = 100;
        System.out.println(j == m);

        int a1 = 1;
        Integer integer1 = new Integer(1);
        System.out.println(integer1.equals(a1));
        System.out.println(integer1);
        System.out.println(Integer.valueOf(a1));

        Integer integer2 = new Integer(1);
        System.out.println(integer1.equals(integer2));
    }
}
