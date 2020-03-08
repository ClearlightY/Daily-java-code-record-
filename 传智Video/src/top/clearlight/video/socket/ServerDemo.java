package top.clearlight.video.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(2345);
        while (true) {
            Socket s = ss.accept();
            Thread t = new Thread(() -> {
                try {
                    InputStream is = s.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String str = br.readLine();
                    String[] st = str.split(" ");
                    String name = st[1];
                    System.out.println(Arrays.toString(st));
                    System.out.println(name);
                    FileInputStream fis = new FileInputStream("F:\\site\\特效" + name);
                    OutputStream os = s.getOutputStream();
                    os.write("HTTP/1.1 200 OK\r\nContent-Type:image/jpeg\r\n\r\n".getBytes());
                    int len;
                    byte[] bytes = new byte[1024];
                    while ((len = fis.read(bytes)) != -1) {
                        os.write(bytes, 0, len);
                    }
                    os.close();
                    fis.close();
                    br.close();
                    is.close();
                    s.close();
                } catch (Exception e) {
                }
            });
            t.start();
        }

    }
}
