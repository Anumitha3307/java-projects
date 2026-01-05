package week1;
import java.util.Scanner;
public class divisibility {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a number");
        n = scanner.nextInt();
        if(n%3==0 && n%5==0){
            System.out.println("the number is divisible by both 3 and 5");
        }
        else{
            System.out.println("the number is not divisible by 3 and 5");
        }
        scanner.close();
    }
}
