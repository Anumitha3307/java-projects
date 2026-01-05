package week1;
import java.util.Scanner;
public class tables {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number");
        int n = scanner.nextInt();
        System.out.println("table of the entered number");
        for(int i = 1;i<=10;i++){
            System.out.println(n+" "+"x"+" "+i+" "+"="+" "+n*i);
        }
        scanner.close();
    }
}
