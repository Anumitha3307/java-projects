package week1;
import java.util.Scanner;


public class sumOfDigits {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.println("enter an integer");
         int number = scanner.nextInt();
         int sum = 0;
         int temp = Math.abs(number);
         while(temp>0){
            sum += temp % 10;
            temp /= 10;
         }
         System.out.println("the sum of the digits is:"+sum);
         scanner.close();

    }
}
