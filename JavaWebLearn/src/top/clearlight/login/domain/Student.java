package top.clearlight.login.domain;

public class Student {
    private String username;
    private String password;
    private String age;

    public String getYears() {
        return age;
    }

    public void setYears(String age) {
        this.age = age;
    }


    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student() {
    }

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
