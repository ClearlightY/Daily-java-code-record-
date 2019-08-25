package cn.com.clearlight.io.datastream.demo;

import java.io.*;

/**
 * 操作基本类型数据的流对象
 */
public class DataStreamDemo {
    public static void main(String[] args) throws IOException {
        // writeData();
        readData();
    }

    private static void readData() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        String str = dis.readUTF();
        System.out.println(str);
    }

    private static void writeData() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        dos.writeUTF("你好");
        dos.close();
    }
}
