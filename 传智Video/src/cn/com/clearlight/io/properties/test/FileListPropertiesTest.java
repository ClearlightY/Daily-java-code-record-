package cn.com.clearlight.io.properties.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileListPropertiesTest {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\87052\\ideaProjects\\传智Video");
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        };
        List<File> list = new ArrayList<>();
        getFiles(dir, filter, list);
        File destFile = new File(dir, "javalist.txt");
        write2File(list,destFile);
    }

    public static void getFiles(File dir, FilenameFilter filter, List<File> list) {
        File[] files = dir.listFiles();

        for (File file :
                files) {
            if (file.isDirectory()) {
                // 递归啦!
                getFiles(file, filter, list);
            } else {
                // 对遍历到的文件进行过滤器的过滤.将符合条件File对象,存储到List集合中
                if (filter.accept(dir, file.getName())) {
                    list.add(file);
                }
            }
        }
    }
    
    public static void write2File(List<File> list, File destFile) {
        BufferedWriter bufw = null;
        try {
            bufw = new BufferedWriter(new FileWriter(destFile));
            for (File file :
                    list) {
                bufw.write(file.getAbsolutePath());
                bufw.newLine();
                bufw.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("写入失败!");
        } finally {
            if (bufw != null) {
                try {
                    bufw.close();
                } catch (IOException e) {
                    throw new RuntimeException("关闭失败!");
                }
            }
        }
    }
}
