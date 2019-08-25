package cn.com.clearlight.io.bytestream.demo;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ByteStreamDemo {
    public static void main(String[] args) throws IOException {
        // demo_write();
        System.out.println();
        ArrayList<String> strings = new ArrayList<>();

        demo_read();
    }

    private static void demo_read() throws IOException {
        // 1. 创建一个读取流对象.和指定文件关联
        FileInputStream fis = new FileInputStream("bytedemo.txt");

        // 一次只能读取一个字节
        // int onlyByte = fis.read();
        // System.out.println((char)onlyByte);

        /*// 2. 一次读取一个字节
        int onlyByte = 0;
        while ((onlyByte = fis.read()) != -1) {
            System.out.print((char)onlyByte);
        }*/


        // 建议使用这种读取方式
       /* byte[] buf = new byte[3];

        int len = 0;

        while ((len = fis.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }*/

        // 如果读取大文件,数组将容不下
        System.out.println(fis.available());
        byte[] onlyByte = new byte[fis.available()];
        fis.read(onlyByte);
        System.out.println(new String(onlyByte));
        // 关闭资源
        fis.close();
    }

    private static void demo_write() throws IOException {
        // 1. 创建字节输出流对象,用于操作文件
        FileOutputStream fos = new FileOutputStream("bytedemo.txt");

        // 2. 写数据
        fos.write("你abcdefg".getBytes());

        // 刷新资源无效
        // fos.flush();

        // 关闭资源
        fos.close();
    }
}
