package top.clearlight.wechat.Thread;

public class Trainl extends Thread {
    private int ticket = 10;
    private String name;

    public Trainl(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println(name + "买票-->" + (this.ticket--));
        }
    }
}
