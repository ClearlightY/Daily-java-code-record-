package top.clearlight.jdbc.itcast.learn.demo.domain;

public class Stu {
    private int id;
    private String stu_username;
    private int stu_password;
    private int stu_weight;

    @Override
    public String toString() {
        return "uesr{" +
                "id=" + id +
                ", stu_username='" + stu_username + '\'' +
                ", stu_password=" + stu_password +
                ", stu_weight=" + stu_weight +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStu_username() {
        return stu_username;
    }

    public void setStu_username(String stu_username) {
        this.stu_username = stu_username;
    }

    public int getStu_password() {
        return stu_password;
    }

    public void setStu_password(int stu_password) {
        this.stu_password = stu_password;
    }

    public int getStu_weight() {
        return stu_weight;
    }

    public void setStu_weight(int stu_weight) {
        this.stu_weight = stu_weight;
    }

    public Stu(int id, String stu_username, int stu_password, int stu_weight) {
        this.id = id;
        this.stu_username = stu_username;
        this.stu_password = stu_password;
        this.stu_weight = stu_weight;
    }

    public Stu() {
    }
}
