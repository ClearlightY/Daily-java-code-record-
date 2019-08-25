package top.clearlight.question;

public class UserTest {
    public static void main(String[] args) {
        User u = new User("bob", 20);
        System.out.println(u.getName() + " : " + u.getAge());
    }
}
