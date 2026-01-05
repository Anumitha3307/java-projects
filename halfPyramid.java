package week1;
import java.util.Scanner;
public class halfPyramid {
    public static void main(String[] args) {
        int n;
        System.out.println("enter the no.of rows");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
            
        }
        scanner.close();
    }
}
