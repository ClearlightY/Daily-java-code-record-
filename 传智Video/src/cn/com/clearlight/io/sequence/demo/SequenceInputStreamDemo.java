package cn.com.clearlight.io.sequence.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 将三个文件合并为一个文件
 */
public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException {
        // Vector<FileInputStream> v = new Vector<>();
        ArrayList<FileInputStream> al = new ArrayList<>();
        al.add(new FileInputStream("javalist.txt"));
        al.add(new FileInputStream("info.txt"));
        al.add(new FileInputStream("buf.txt"));

        Enumeration<FileInputStream> en = Collections.enumeration(al);

        SequenceInputStream sis = new SequenceInputStream(en);

        FileOutputStream fos = new FileOutputStream("combine2.txt");

        byte[] buf = new byte[1024];

        int len = 0;

        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }

        fos.close();
        sis.close();
    }
}
