package week1;
import java.util.Scanner;
public class banking {
    public static void main(String[] args) {
        int n;
        int bal = 50000;
        Scanner scn = new Scanner(System.in);
        System.out.println("1.deposit money\n2.withdraw money\n3.check bankbalance\n4.exit");
        System.out.println("select the choice");
        n = scn.nextInt();
        switch(n){
            case 1:{
                System.out.println("enter the amount to deposit:");
                int m = scn.nextInt();
                if(m<0){
                    System.out.println("failed operation\nenter valid amount to deposit");

                }
                else{
                    System.out.println("succesful operation\nmoney deposited");
                    bal+= m;
                    System.out.println("current balance:"+bal);
                }
                break;
            }
            case 2:{
                System.out.println("enter the amount to withdraw");
                int w = scn.nextInt();
                if(w>bal){
                    System.out.println("failed operation\nenter the valid amount to withdraw");
                }
                else{
                    System.out.println("succesful operation");
                    bal-= w;
                    System.out.println("current balance:"+bal);
                }
                break;
            }
            case 3:{
                System.out.println("current balance in the account:"+bal);
                break;
            }
            case 4:{
                System.out.println("exited");
                break;
            }
        }
        scn.close();
    }
    
}
