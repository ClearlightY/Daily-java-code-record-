package cn.com.clearlight.io.buffer.bufferedtest;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemoTest {
    public static void main(String[] args) throws IOException {
        // demo();
        FileReader fr = new FileReader("buf.txt");

        MyBufferedReader bufr = new MyBufferedReader(fr);


        String line = null;
        while ((line = bufr.myReadLine()) != null) {
            System.out.println("line = " + line);
        }

        bufr.close();
    }
}
