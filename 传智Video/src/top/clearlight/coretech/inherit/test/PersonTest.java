package top.clearlight.coretech.inherit.test;

public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];

        // fill the people array with Student and Employee objects
        people[0] = new Employee("Harry", 50000, 1999, 1, 1);
        people[1] = new Employee("Mary", 3000, 2000, 2, 1);

        // print out names and descriptions of all Person objects
        for (Person person : people) {
            System.out.println(person.getName() + ", " + person.getDescription());
        }
    }
}
