package week9;

import java.util.*;

class Student implements Comparable<Student> {
    private int rollNumber;
    private String name;
    private int marks;

    public Student(int rollNumber, String name, int marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.marks, other.marks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return rollNumber == student.rollNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber);
    }

    @Override
    public String toString() {
        return rollNumber + " - " + name + " - " + marks;
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Same roll number means same student
        if (s1.getRollNumber() == s2.getRollNumber()) return 0;

        // Sort by marks
        int markCompare = Integer.compare(s1.getMarks(), s2.getMarks());
        if (markCompare != 0) return markCompare;

        // Sort by name
        return s1.getName().compareTo(s2.getName());
    }
}

public class UniversityGradingSystem {
    public static void main(String[] args) {
        Set<Integer> rollNumberSet = new HashSet<>();
        TreeSet<Student> sortedStudents = new TreeSet<>(new StudentComparator());

        // Helper method to add student
        addStudent(new Student(101, "Alice", 85), rollNumberSet, sortedStudents);
        addStudent(new Student(102, "Bob", 90), rollNumberSet, sortedStudents);
        addStudent(new Student(103, "Charlie", 85), rollNumberSet, sortedStudents);
        addStudent(new Student(104, "David", 92), rollNumberSet, sortedStudents);
        addStudent(new Student(105, "Alice", 85), rollNumberSet, sortedStudents);
        addStudent(new Student(101, "Eve", 75), rollNumberSet, sortedStudents); // duplicate rollNumber, not added

        for (Student s : sortedStudents) {
            System.out.println(s);
        }
    }

    public static void addStudent(Student s, Set<Integer> rollSet, TreeSet<Student> sortedSet) {
        if (rollSet.add(s.getRollNumber())) {
            sortedSet.add(s);
        } else {
            System.out.println("Duplicate roll number, student not added: " + s.getRollNumber());
        }
    }
}
