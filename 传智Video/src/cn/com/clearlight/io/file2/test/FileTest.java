package cn.com.clearlight.io.file2.test;

import java.io.File;

/**
 * 打印目录下的所有子文件
 */
public class FileTest {
    public static void main(String[] args) {
        File dir = new File("E:\\安装包");
        listAll(dir);
    }

    private static void listAll(File dir) {
        System.out.println("dir:" + dir.getAbsolutePath());
        // 获取指定目录下当前的所有文件夹或者文件对象
        File[] files = dir.listFiles();

        for (int x = 0; x < files.length; x++) {
            if (files[x].isDirectory()) {
                listAll(files[x]);
            } else {
                System.out.println(files[x].getAbsolutePath());
            }
        }
    }
}
