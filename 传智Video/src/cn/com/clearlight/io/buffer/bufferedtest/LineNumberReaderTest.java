package cn.com.clearlight.io.buffer.bufferedtest;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * 跟踪行号的缓冲字符输入流。
 * 此类定义了方法 setLineNumber(int) 和 getLineNumber()，它们可分别用于设置和获取当前行号。
 */
public class LineNumberReaderTest {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("buf.txt");
        LineNumberReader lnr = new LineNumberReader(fr);

        String line = null;
        // lnr.setLineNumber(2);
        while ((line = lnr.readLine()) != null) {
            System.out.println(lnr.getLineNumber() + ":" + line);
        }
    }
}
