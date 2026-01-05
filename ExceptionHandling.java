package week6;


import java.util.Scanner;
// import.java.util.Arrays;

public class ExceptionHandling {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("Division Operation:");
        int n1;
        int n2;
        int result = 1;
        while(true){

            try{
                System.out.print("Enter the numerator:");
                n1 = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter the denominator:");
                n2 = Integer.parseInt(scanner.nextLine());
                result = n1/n2;
                System.out.println("Result is:"+ result);
                break;
            }
            catch(ArithmeticException ae){
                System.out.println("Error is: Division by zero is not allowed. Please try again" );
            }
            catch(NumberFormatException nfe){
                System.out.println("Invalid Input, Please enter integers");
            }

        }
    }
}            
