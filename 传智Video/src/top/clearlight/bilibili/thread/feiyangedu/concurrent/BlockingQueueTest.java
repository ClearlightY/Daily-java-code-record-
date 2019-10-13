package top.clearlight.bilibili.thread.feiyangedu.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class WorkerThread1 extends Thread {
    BlockingQueue<String> taskQueue;

    public WorkerThread1(BlockingQueue<String> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            String name;
            try {
                name = taskQueue.take();
            } catch (InterruptedException e) {
                break;
            }
            String result = "Hello, " + name + "!";
            System.out.println(result);
        }
    }
}

public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> taskQueue = new ArrayBlockingQueue<>(100);
        WorkerThread1 worker = new WorkerThread1(taskQueue);
        worker.start();
        //  add task
        taskQueue.put("Bob");
        Thread.sleep(1000);
        taskQueue.put("Alice");
        Thread.sleep(1000);
        taskQueue.put("Mary");
        Thread.sleep(1000);
        worker.interrupt();
        worker.join();
        System.out.println("END");
    }

}
