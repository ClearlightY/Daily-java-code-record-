package top.clearlight.bilibili.thread.unknown.System12306;

public class Ticket {

    private String start;
    private String end;
    private Float price;

    public Ticket() {}

    public Ticket(String start, String end, Float price) {
        this.start = start;
        this.end = end;
        this.price = price;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.start);
        sb.append("-->");
        sb.append(this.end);
        sb.append(":");
        sb.append(this.price);
        sb.append("]");
        return sb.toString();
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
