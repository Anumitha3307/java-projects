package week4;

import java.util.Scanner;

interface Calculator {
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
    double power(double base, double exponent);
    long factorial(int n);
}

class ScientificCalculator implements Calculator {
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("invalid input");
        }
        return a / b;
    }

    @Override
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    @Override
    public long factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

public class CalculatorApp {
    public static void main(String[] args) {
        ScientificCalculator calculator = new ScientificCalculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Power");
            System.out.println("6. Factorial");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 7) {
                System.out.println("Exiting...");
                break;
            }

            
                switch (choice) {
                    case 1: 
                        System.out.print("Enter first number: ");
                        double addA = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        double addB = scanner.nextDouble();
                        System.out.println("Result: " + calculator.add(addA, addB));
                        break;

                    case 2: 
                        System.out.print("Enter first number: ");
                        double subA = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        double subB = scanner.nextDouble();
                        System.out.println("Result: " + calculator.subtract(subA, subB));
                        break;

                    case 3: 
                        System.out.print("Enter first number: ");
                        double mulA = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        double mulB = scanner.nextDouble();
                        System.out.println("Result: " + calculator.multiply(mulA, mulB));
                        break;

                    case 4: 
                        System.out.print("Enter first number: ");
                        double divA = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        double divB = scanner.nextDouble();
                        System.out.println("Result: " + calculator.divide(divA, divB));
                        break;

                    case 5:
                        System.out.print("Enter base: ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter exponent: ");
                        double exponent = scanner.nextDouble();
                        System.out.println("Result: " + calculator.power(base, exponent));
                        break;

                    case 6:
                        System.out.print("Enter a number: ");
                        int n = scanner.nextInt();
                        System.out.println("Result: " + calculator.factorial(n));
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
        }    
        scanner.close();
    }
}        
             
        

