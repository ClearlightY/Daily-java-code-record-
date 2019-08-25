package cn.com.clearlight.io.file.filetest;

import java.io.*;

public class CopySelfTest {
    public static void main(String[] args) throws IOException {
        copy_1();
    }

    private static void copy_1() throws IOException {
        // InputStreamReader isr = new InputStreamReader(new BufferedInputStream(new FileInputStream("buf.txt")));
        // OutputStreamWriter osw = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("test.txt")));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = 0;
        while ((len = br.read()) != -1) {
            bw.write(len);
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
