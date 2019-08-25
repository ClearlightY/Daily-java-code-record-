package cn.com.clearlight.io.bytestream.test;

import java.io.*;

public class CopyMp3Test {
    public static void main(String[] args) throws IOException {
        // copy_1();
        // copy_2();
        copy_3();
    }

    private static void copy_3() throws IOException {
        FileInputStream fis = new FileInputStream("H:\\音乐\\富爸爸穷爸爸\\1.mp3");
        BufferedInputStream bufis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream("H:\\音乐\\01.mp3");
        BufferedOutputStream bufos = new BufferedOutputStream(fos);

        byte[] buf = new byte[bufis.available()];
        bufis.read(buf);
        bufos.write(buf);


        bufis.close();
        bufos.close();
    }

    private static void copy_2() throws IOException {
        // 1. 读取文件
        FileInputStream fis = new FileInputStream("H:\\音乐\\富爸爸穷爸爸\\4.mp3");
        BufferedInputStream bufis = new BufferedInputStream(fis);

        // 2. 写入文件
        FileOutputStream fos = new FileOutputStream("H:\\音乐\\04.mp3");
        BufferedOutputStream bufos = new BufferedOutputStream(fos);

        int ch = 0;
        // 先将数据读到缓冲区中,后从缓冲区中向硬盘中写入数据
        while ((ch = bufis.read()) != -1) {
            bufos.write(ch);
        }

        // 关闭资源
        bufis.close();
        bufos.close();

    }

    private static void copy_1() throws IOException {
        // 1. 读取文件
        FileInputStream fis = new FileInputStream("H:\\音乐\\富爸爸穷爸爸\\4.mp3");

        // 2. 写入文件
        FileOutputStream fos = new FileOutputStream("H:\\音乐\\04.mp3");

        byte[] buf = new byte[1024];

        int ch = 0;
        while ((ch = fis.read(buf)) != -1) {
            fos.write(buf, 0, ch);
        }

        // 关闭资源
        fis.close();
        fos.close();
    }
}
