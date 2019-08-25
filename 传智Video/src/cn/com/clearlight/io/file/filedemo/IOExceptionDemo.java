package cn.com.clearlight.io.file.filedemo;

import java.io.FileWriter;
import java.io.IOException;

/**
 * IO异常的简单处理
 */
public class IOExceptionDemo {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("O:\\demo.txt");
            fw.write("aaa");
            fw.flush();
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException("关闭失败");
            }
        }
    }
}
