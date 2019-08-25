package cn.com.clearlight.io.file.filedemo;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 需求 : 读取一个文本文件. 将读取到的字符打印到控制台.
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        /*
        1.创建读取字符数据的流对象
        在创建读取流对象时,必须要明确被读取的文件.一定要确定该文件是存在的
        用一个 读取流关联一个已存在文件
         */
        try {
            FileReader fr = new FileReader("demo.txt");

            // 每次只可以读取一个字符.
            /* // 用Reader中read方法读取字符
            int ch = fr.read();
            System.out.println(ch);*/

            int ch = 0;

            //   一次读取一个字符,通过循环依次读取
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
