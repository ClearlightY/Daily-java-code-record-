package cn.com.clearlight.io.test.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferReaderDemo {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("buf1.txt");

        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 0; i < 5; i++) {
            bw.write("hello" + i);
            bw.newLine();
            bw.flush();
        }


        bw.close();
    }
}
