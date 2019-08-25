package top.clearlight.wechat.Thread;

public class Animal implements Runnable {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i+=10) {
            if (this.getName().equals("乌龟")) {
                System.out.println("\t\t乌龟跑了" + i + "米");
            } else {
                System.out.println(this.getName() + "跑了" + i + "米");
            }
        }
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            System.out.println("报错了???");
        }
    }
}
