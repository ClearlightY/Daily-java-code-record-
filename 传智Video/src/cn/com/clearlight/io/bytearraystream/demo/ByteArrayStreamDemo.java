package cn.com.clearlight.io.bytearraystream.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStreamDemo {
    public static void main(String[] args) {
        ByteArrayInputStream bis = new ByteArrayInputStream("abcdef".getBytes());

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int ch = 0;

        while ((ch = bis.read()) != -1) {
            bos.write(ch);
        }
        System.out.println(bos.toString());
    }
}
