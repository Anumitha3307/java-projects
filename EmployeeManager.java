package week2;

class Employee {
    String name; // Default access
    protected int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Manager extends Employee {
    public Manager(String name, int age, double salary) {
        super(name, age, salary);
    }

    public void displayInfo() {
        System.out.println("Name: " + name); // Accessible (default access in the same package)
        System.out.println("Age: " + age); // Accessible (protected access inherited)
        
        // System.out.println("Salary: " + salary); // Not accessible directly (private field)
        System.out.println("Salary: " + getSalary()); // Accessed through getter
    }

    public void updateSalary(double newSalary) {
        setSalary(newSalary); // Modifying private field through setter
    }
}

public class EmployeeManager {
    public static void main(String[] args) {
        Manager manager = new Manager("Alice Smith", 40, 75000);
        manager.displayInfo();
        
        // Updating salary through setter
        manager.updateSalary(80000);
        System.out.println("Updated Salary: " + manager.getSalary());
    }
}

