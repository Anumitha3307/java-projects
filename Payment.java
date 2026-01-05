package week4;
import java.util.Scanner;
interface Processing{
    void paymentProcessing();
} 
class CreditCard implements Processing{
    private double amount;
    public CreditCard(double amount){
        this.amount = amount;
    }
    @Override
    public void paymentProcessing(){
       System.out.println("the amount"+amount+"credited from the credit card");
    }   
}
class DebitCard implements Processing{
    private double amount;
    public DebitCard(double amount){
        this.amount = amount;
    }
    
    @Override
    public void paymentProcessing(){
       System.out.println("the amount"+amount+"credited from the debit card");
    }
}
class PayPal implements Processing{
    private double amount;
    public PayPal (double amount){
        this.amount = amount;
    }
    @Override
    public void paymentProcessing(){
       System.out.println("the amount"+amount+"credited from the paypal card");
    }
}

public class Payment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Processing dc = new DebitCard(500);
        Processing cc = new CreditCard(500);
        Processing pp = new PayPal(500);
        System.out.println("1-debit card");
        System.out.println("2-credit card");
        System.out.println("3-paypal");
        System.out.println("enter the choice");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
            {
                dc.paymentProcessing();
                break;
            }
            case 2:
            {
                cc.paymentProcessing();
                break;
            }
            case 3:
            {
                pp.paymentProcessing();
                break;
            }
        }
        sc.close();


    }
}
