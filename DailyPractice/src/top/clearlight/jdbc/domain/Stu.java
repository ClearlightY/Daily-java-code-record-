package top.clearlight.jdbc.domain;

public class Stu {
    private Integer stu_id;
    private String stu_username;
    private Integer stu_password;
    private Integer stu_weight;

    @Override
    public String toString() {
        return "Stu{" +
                "stu_id=" + stu_id +
                ", stu_username='" + stu_username + '\'' +
                ", stu_password=" + stu_password +
                ", stu_weight=" + stu_weight +
                '}';
    }

    public Integer getStu_id() {
        return stu_id;
    }

    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_username() {
        return stu_username;
    }

    public void setStu_username(String stu_username) {
        this.stu_username = stu_username;
    }

    public Integer getStu_password() {
        return stu_password;
    }

    public void setStu_password(Integer stu_password) {
        this.stu_password = stu_password;
    }

    public Integer getStu_weight() {
        return stu_weight;
    }

    public void setStu_weight(Integer stu_weight) {
        this.stu_weight = stu_weight;
    }

    public Stu(Integer stu_id, String stu_username, Integer stu_password, Integer stu_weight) {
        this.stu_id = stu_id;
        this.stu_username = stu_username;
        this.stu_password = stu_password;
        this.stu_weight = stu_weight;
    }

    public Stu() {
    }
}
