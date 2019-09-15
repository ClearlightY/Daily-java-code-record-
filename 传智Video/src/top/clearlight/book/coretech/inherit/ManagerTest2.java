package top.clearlight.book.coretech.inherit;

public class ManagerTest2 {
    public static void main(String[] args) {
        Employee employee = new Manager("Bob", 2000, 2019, 1, 1);
        // employee.
        double salary = employee.getSalary();
        System.out.println(salary);
        employee.test(2);
        Manager manager = new Manager("Jack", 1800, 2019, 2, 2);
        manager.setBonus(200);
        manager.getSalary();
        manager.test(1);

        Manager employee1 = (Manager) employee;
        employee1.setBonus(100);
        double salary1 = employee1.getSalary();
        System.out.println(salary1);

        Employee em = new Employee("Mary", 2000, 2010, 1, 2) {
            @Override
            public void test(int a) {
                System.out.println("a o");
            }
        };
        if (em instanceof Manager) {
            Manager em1 = (Manager) em;
            em1.setBonus(100);
            double salary2 = em1.getSalary();
            System.out.println(salary2);
        } 

       em.test(1);
    }
}
