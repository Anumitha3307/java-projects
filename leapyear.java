package week1;
import java.util.Scanner;

public class leapyear {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n;
    System.out.println("enter year:");
    n=scanner.nextInt();
    if(n%4==0&&n%100!=0||n%400==0){
        System.out.println("leap");
    }
    else
         System.out.println("not leap");
         scanner.close();
    }
    
    
    }
    

