package top.clearlight.question;

import java.util.ArrayList;
import java.util.List;

public class GlobalMessage {
    List list = new ArrayList();

    public GlobalMessage(){

    }

    public void test(List list) {
        list.add(1);
        list.add(2);
        System.out.println(list);
    }
    public void test3() {
        list.add(10);
    }

    public void test2() {
        list.add(5);
        test(list);
        test3();
        System.out.println(list);
    }

    public static void main(String[] args) {
        // System.out.println(list);
        // new GlobalMessage().test(list);
        // System.out.println(list);

        new GlobalMessage().test2();
    }
}
