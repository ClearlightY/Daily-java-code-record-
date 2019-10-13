package top.clearlight.bilibili.thread.feiyangedu.future;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;
import java.util.concurrent.*;

class DownloadTask implements Callable<String> {

    String url;

    public DownloadTask(String url) {
        this.url = url;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Start download " + url + "...");
        URLConnection conn = new URL(this.url).openConnection();
        conn.connect();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String s = null;
            StringBuilder sb = new StringBuilder();
            while ((s = reader.readLine()) != null) {
                sb.append(s).append("\n");
            }
            return sb.toString();
        }
    }
}

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        DownloadTask task = new DownloadTask("http://www.clearlight.top/");
        Future<String> future = executor.submit(task);
        String html = future.get();
        System.out.println(html);
        executor.shutdown();
    }
}
