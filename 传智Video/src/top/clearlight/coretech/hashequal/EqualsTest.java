package top.clearlight.coretech.hashequal;

import javax.sound.midi.Soundbank;

public class EqualsTest {
    public static void main(String[] args) {
        Employee a1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        Employee a2 = a1;
        Employee a3 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        Employee bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);

        System.out.println("a1 == a2: " + (a1 == a2));
        System.out.println("a1 == a3: " + (a1 == a3));
        System.out.println("a1.equals(a3): " + a1.equals(a3));
        System.out.println("a1.equals(bob): " + a1.equals(bob));
        System.out.println("bob.toString(): " + bob);

        Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        System.out.println("boss.toString(): " + boss);
        System.out.println("carl.equals(boss): " + carl.equals(boss));
        System.out.println("a1.hashCode(): " + a1.hashCode());
        System.out.println("a3.hashCode(): " + a3.hashCode());
        System.out.println("bob.hashCode(): " + bob.hashCode());
        System.out.println("carl.hashCode(): " + carl.hashCode());

        System.out.println(carl.getClass());
        System.out.println(carl.getClass().getName());
        Object a = new Object();
        System.out.println(a.getClass());
        System.out.println(a.getClass().getName());
    }
}
