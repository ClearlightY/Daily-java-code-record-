package top.clearlight.question;

public class User {
    private String name;
    private int age;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String sex) {
        this("any", 20);
        // 错误的做法
        // User("any", 20);
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public static void main(String[] args) {
        User user = new User("jack", 18);
        System.out.println(user.getName() + " : " + user.getAge());
        User user1 = new User("女");
        System.out.println(user1.getName() + " : " + user1.getAge() + " : " + user1.getSex());
    }
}
