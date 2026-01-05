package week1;
import java.util.Scanner;
public class repeatNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number");
        int num = scanner.nextInt();
        while(num != 0){
            System.out.println("enter the number");
            num = scanner.nextInt();
            System.out.printf("your number is %d \n",num);
        }
        scanner.close();

    }
}
