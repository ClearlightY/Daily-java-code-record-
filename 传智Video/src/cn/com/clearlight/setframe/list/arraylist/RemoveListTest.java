package cn.com.clearlight.setframe.list.arraylist;

import java.util.ArrayList;
import java.util.List;

public class RemoveListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");


        for (String s :
                list) {
            if (s.equals("1")) {
                list.remove(s);
            }
        }


    }
}
