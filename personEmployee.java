package week2;

class Person {
    protected String name;
    protected int age;
    protected String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }
}

class Employee extends Person {
    private String employeeId;
    private String department;
    private double salary;

    public Employee(String name, int age, String gender, String employeeId, String department, double salary) {
        super(name, age, gender);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }

    public void displayEmployeeInfo() {
        super.displayPersonInfo();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + String.format("%.2f", salary));
    }
}

public class personEmployee {
    public static void main(String[] args) {
        Employee employee = new Employee("Alice Johnson", 30, "Female", "E12345", "HR", 60000);
        employee.displayEmployeeInfo();
    }
}
