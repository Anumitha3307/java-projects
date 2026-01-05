package week2;

class Person {
    public String name;
    protected int age;
    String address; // Default access modifier
    private String ssn;

    public Person(String name, int age, String address, String ssn) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.ssn = ssn;
    }

    public String getSsn() {
        return ssn;
    }
}

public class AccessModifiers {
    public static void main(String[] args) {
        Person person = new Person("John Doe", 30, "123 Street, NY", "123-45-6789");

        // Accessing public field
        System.out.println("Name: " + person.name);

        // Accessing protected field
        System.out.println("Age: " + person.age);

        // Accessing default (package-private) field
        System.out.println("Address: " + person.address);

        // Accessing private field using getter
        System.out.println("SSN: " + person.getSsn());
    }
}

