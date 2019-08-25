package top.clearlight.bilibili.Thread.System12306;

public class Window extends Thread {

    private String windowName;

    public Window(String windowName) {
        this.windowName = windowName;
    }

    @Override
    public void run() {
        this.sellTicket();
    }

    public void sellTicket() {
        while (true) {
            System12306 sys = System12306.getInstance();
            Ticket ticket = sys.getTicket();
            if (ticket == null) {
                System.out.println("抱歉, "+ windowName +"窗口车票已售完.");
                break;
            }
            System.out.println("从" + windowName + "售出:" + ticket);
        }
    }
}
