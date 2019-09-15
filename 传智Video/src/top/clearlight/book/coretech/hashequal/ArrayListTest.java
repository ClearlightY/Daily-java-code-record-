package top.clearlight.book.coretech.hashequal;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();

        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        staff.add(new Employee("Harry Hacker", 50000, 1937, 12, 15));
        staff.add(new Employee("Carl Cracker", 29000, 1997, 10, 15));

        for (Employee e :
                staff) {
            e.raiseSalary(5);
        }

        for (Employee e :
                staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary()
                + ",hireDay=" + e.getHireDay());
        }
    }
}
