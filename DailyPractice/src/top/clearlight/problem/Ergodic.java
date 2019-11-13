package top.clearlight.problem;

import java.util.ArrayList;
import java.util.List;

public class Ergodic {
    public static void main(String[] args) {

        System.out.println("ArrayList集合的遍历");
        List list = new ArrayList();
        list.add(1);
        list.add(2);

        list.stream().forEach(System.out::println);
    }
}