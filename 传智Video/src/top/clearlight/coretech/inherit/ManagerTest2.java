package top.clearlight.coretech.inherit;

public class ManagerTest2 {
    public static void main(String[] args) {
        Employee employee = new Manager("Bob", 2000, 2019, 1, 1);
        // employee.
        employee.getSalary();
        employee.test(2);
        Manager manager = new Manager("Jack", 1800, 2019, 2, 2);
        manager.setBonus(200);
        manager.getSalary();
        manager.test(1);
    }
}
