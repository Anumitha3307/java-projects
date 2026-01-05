package minor2;

import java.util.*;

// Student class
class Student implements Comparable<Student> {
    int studentId;
    String name;
    String course;
    double gpa;

    public Student(int studentId, String name, String course, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.gpa = gpa;
    }

    // Override equals and hashCode to ensure uniqueness by studentId
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return studentId == student.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    // For TreeSet sorting by name
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return studentId + " - " + name + " (" + course + ", GPA: " + gpa + ")";
    }
}

public class StudentManagementSystem {
    HashSet<Student> studentSet = new HashSet<>();

    // Add student without duplicates
    public void addStudent(int id, String name, String course, double gpa) {
        Student student = new Student(id, name, course, gpa);
        if (studentSet.add(student)) {
            System.out.println(name + " added successfully.");
        } else {
            System.out.println("Student with ID " + id + " already exists!");
        }
    }

    // Search student by ID
    public Student searchStudentById(int id) {
        for (Student student : studentSet) {
            if (student.studentId == id) {
                return student;
            }
        }
        return null;
    }

    // Display students sorted by name
    public void displayStudentsSortedByName() {
        TreeSet<Student> sortedSet = new TreeSet<>(studentSet);
        for (Student student : sortedSet) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        
        // Adding students
        sms.addStudent(101, "Alice", "Computer Science", 3.8);
        sms.addStudent(102, "Bob", "Mathematics", 3.6);
        sms.addStudent(103, "Charlie", "Computer Science", 3.9);

        System.out.println("\nStudents sorted by name:");
        sms.displayStudentsSortedByName();

        System.out.println("\nSearching for student with ID 102:");
        Student found = sms.searchStudentById(102);
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Student not found.");
        }
    }
}        
