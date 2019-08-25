package cn.com.clearlight.io.file.filetest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 需求 : 将c盘一个文本文件复制到d盘
 * <p>
 * 思路 :
 * 1. 需要读取源
 * 2. 将读取到的源数据写入到目的地
 * 3. 既然是操作文本数据,使用字符流
 */
public class CopyTextTest {
    public static void main(String[] args) throws IOException {

        // 1. 读取一个已有的文本文件,使用字符流和文件相关联
        FileReader fr = new FileReader("F:\\filetest.txt");
        // 2. 创建一个目的地,用于存储读到的数据
        FileWriter fw = new FileWriter("copyFiletest.txt");
        // 3. 频繁的读写操作
        char[] buf = new char[1024];
        int ch = 0;
        while ((ch = fr.read(buf)) != -1) {
            fw.write(buf, 0, ch);
        }
       /* int ch = 0;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }*/
        // 4. 关闭流资源
        fw.close();
        fr.close();
    }
}
