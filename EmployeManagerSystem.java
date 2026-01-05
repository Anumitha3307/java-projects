package week3;
class Employee {
    private String name;
    private int age;
    private final double salary; 
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age + ", Salary: " + salary);
    }
}
class Manager extends Employee {
    private String department;
    public Manager(String name, int age, double salary, String department) {
        super(name, age, salary); 
        this.department = department;
    }
    @Override
    public void displayDetails() {
        super.displayDetails(); 
        System.out.println("Department: " + department);
    }
}

public class EmployeManagerSystem {
    public static void main(String[] args) {
        Employee employee = new Employee("Alice", 30, 50000.0);
        System.out.println("Employee Details:");
        employee.displayDetails();

        Manager manager = new Manager("Bob", 40, 70000.0, "IT");
        System.out.println("\nManager Details:");
        manager.displayDetails();
    }
}

