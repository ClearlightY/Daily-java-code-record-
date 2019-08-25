package cn.com.clearlight.io.transstream.demo;

import java.io.*;

public class TransStreamDemo {
    public static void main(String[] args) throws IOException {
        // in : “标准”输入流。此流已打开并准备提供输入数据。
        //      通常，此流对应于键盘输入或者由主机环境或用户指定的另一个输入源。
        // 因此将键盘的输入作为数据读取到输入流中
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        // “标准”输出流。此流已打开并准备接受输出数据。
        // 通常，此流对应于显示器输出或者由主机环境或用户指定的另一个输出目标
        // 因此数据写入到输出流中显示在显示器中
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;

        while ((line = bufr.readLine()) != null) {
            if ("over".equals(line)) {
                return;
            }
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }

        bufr.close();
        bufw.close();
    }
}
