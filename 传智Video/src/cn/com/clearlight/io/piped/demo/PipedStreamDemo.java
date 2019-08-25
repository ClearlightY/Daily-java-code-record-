package cn.com.clearlight.io.piped.demo;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {
    public static void main(String[] args) throws IOException {
        PipedInputStream input = new PipedInputStream();
        PipedOutputStream output = new PipedOutputStream();

        input.connect(output);

        new Thread(new Input(input)).start();
        new Thread(new Output(output)).start();
    }

}
class Input implements Runnable {
    private PipedInputStream in;

    Input(PipedInputStream in) {
        this.in = in;
    }
    @Override
    public void run() {
        try {
            byte[] buf = new byte[1024];
            int len = in.read(buf);

            String s = new String(buf, 0, len);

            System.out.println("s = " + s);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Output implements Runnable {
    private PipedOutputStream out;

    Output(PipedOutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            out.write("hi,come 管道".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
