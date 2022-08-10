package employee;

import java.util.Iterator;
import java.util.function.Consumer;

public class Employee {

    private static int employeeNumber;

    private final int id;
    private String firstName;
    private String lastname;
    private int salary;
    private int age;
    private int startingYear;

    public Employee(String firstName, String lastname, int salary, int age, int startingYear) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.salary = salary;
        this.age = age;
        this.startingYear = startingYear;
        id = ++employeeNumber;
    }

    public static int getEmployeeNumber() {
        return employeeNumber;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {return firstName;}

    public String getLastname() {
        return lastname;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getFullName(){
        return getFirstName() + " " + getLastname();
    }

    public int getStartingYear() {
        return startingYear;
    }

    @Override
    public String toString() {
        return "employee.Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", startingYear=" + startingYear +
                '}';
    }
}
