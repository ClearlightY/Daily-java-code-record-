package top.clearlight.book.coretech.inherit;

public class Manager extends Employee {
    private double bonus;


    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    @Override
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    @Override
    public void test(int a) {
        System.out.println("实现抽象类");
    }

    public double getSalary(double a) {
        return 2;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
