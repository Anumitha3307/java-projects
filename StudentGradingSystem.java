package Assignment;

import java.util.Scanner;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

class Student {
    public void validateMarks(int marks) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100.");
        } else {
            System.out.println("Marks are valid: " + marks);
        }
    }
}

class InternalAssessment extends Student {
    @Override
    public void validateMarks(int marks) throws InvalidMarksException {
        System.out.println("Internal assessment validation");
        super.validateMarks(marks);
    }
}

public class StudentGradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InternalAssessment assessment = new InternalAssessment();
        
        try {
            System.out.print("Enter marks: ");
            int marks = scanner.nextInt();
            assessment.validateMarks(marks);
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
        } finally {
            System.out.println("Marks validation completed.");
            scanner.close();
        }
    }
}
