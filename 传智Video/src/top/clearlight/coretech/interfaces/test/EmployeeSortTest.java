package top.clearlight.coretech.interfaces.test;

import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry", 35000);
        staff[1] = new Employee("Jack", 75000);
        staff[2] = new Employee("Marry", 28899);

        Arrays.sort(staff);

        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());
        }
    }
}
