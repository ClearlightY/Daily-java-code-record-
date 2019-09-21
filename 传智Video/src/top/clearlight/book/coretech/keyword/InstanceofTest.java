package top.clearlight.book.coretech.keyword;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InstanceofTest {
    public static void main(String[] args) {
        Logger.getGlobal().info("File->Open menu item selected");

        System.out.println();
        ArrayList list = new ArrayList();
        System.out.println(list instanceof List);
        System.out.println(list instanceof ArrayList);
        System.out.println(list instanceof AbstractList);
        System.out.println(list instanceof Object);
        System.out.println(list instanceof RandomAccess);
        System.out.println(list instanceof Serializable);

        Logger.getGlobal().setLevel(Level.OFF); // 取消所有的日志

        System.out.println(null instanceof List);
        Logger.getGlobal().info("ddd");
        // System.out.println('a' instanceof Character);
    }
}
