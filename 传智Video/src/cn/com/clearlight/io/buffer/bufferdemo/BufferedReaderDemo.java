package cn.com.clearlight.io.buffer.bufferdemo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        // demo();
        FileReader fr = new FileReader("buf.txt");

        BufferedReader bufr = new BufferedReader(fr);

        /*String line1 = bufr.readLine();
        System.out.println("line1 = " + line1);
        String line2 = bufr.readLine();
        System.out.println("line1 = " + line2);
        String line3 = bufr.readLine();
        System.out.println("line1 = " + line3);
        String line4 = bufr.readLine();
        System.out.println("line1 = " + line4);
        String line5 = bufr.readLine();
        System.out.println("line5 = " + line5);*/
        String line = null;
        while ((line = bufr.readLine()) != null) {
            System.out.println("line = " + line);
        }
    }

    private static void demo() throws IOException {
        FileReader fr = new FileReader("buf.txt");

        char[] buf = new char[1024];

        int len = 0;
        // read方法: 将字符读入数组. 返回结果为读取的字符长度,如果已经到达流的结尾, 则返回 -1.
        while ((len = fr.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }

        fr.close();
    }
}
