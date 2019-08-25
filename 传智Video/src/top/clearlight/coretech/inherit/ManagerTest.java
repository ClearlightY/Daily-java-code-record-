package top.clearlight.coretech.inherit;

public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("Jack", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];

        staff[0] = boss;
        // staff[1] = new Employee("Hack", 80000, 1989, 10, 1);
        // staff[2] = new Employee("Jerry", 40000, 1990, 3, 1);

        if (staff[1] instanceof Manager) {
            Manager man = (Manager) staff[1];
        }

        staff[0].test(10);

        for (Employee e :
                staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }

        Employee emp = new Manager("Mike", 1000, 2000, 1, 1);
        emp.getSalary(2);
    }
}
