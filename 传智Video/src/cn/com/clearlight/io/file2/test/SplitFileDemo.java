package cn.com.clearlight.io.file2.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SplitFileDemo {
    private static final int SIZE = 1024 * 1024;

    public static void main(String[] args) throws IOException {
        splitFile(new File("c:\\love.mp3"));
    }

    public static void splitFile(File file) throws IOException {
        // 用读取流关联源文件
        FileInputStream fis = new FileInputStream(file);

        // 定义一个1M的缓冲区
        byte[] buf = new byte[SIZE];

        // 创建目的
        FileOutputStream fos = null;

        int len = 0;
        int count = 1;

        /**
         * 切割文件时,必须记录被切割文件的名称,以继切割出来碎片文件的个数.方便与合并
         * 这个信息为了进行描述,使用键值对的方式.用到了properties对象
         */
        Properties prop = new Properties();

        File dir = new File("c:\\partFiles");
        if (!dir.exists()) {
            dir.mkdir();
        }

        while ((len = fis.read(buf)) != -1) {
            fos = new FileOutputStream(new File(dir, (count++) + ".part"));
            fos.write(buf, 0, len);
            fos.close();
        }
        prop.setProperty("partCount", count + "");
        prop.setProperty("filename", file.getName());

        fos = new FileOutputStream(new File(dir, count + ".properties"));

        // 将prop集合中的数据存储到文件中
        prop.store(fos, "save file info");

        fos.close();
        fis.close();
    }

}
