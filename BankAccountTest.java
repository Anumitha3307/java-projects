package week3;

abstract class BankAccount {
    // Balance variable to store the account balance
    protected double balance;

    // Constructor to initialize balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Abstract methods to be implemented by subclasses
    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    // Method to display the current balance
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

// Final class SavingsAccount extends BankAccount
final class SavingsAccount extends BankAccount {
    private double interestRate; // Interest rate for savings account

    // Constructor to initialize balance and interest rate
    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    // Deposit method adds interest to the deposited amount
    @Override
    void deposit(double amount) {
        balance += amount + (amount * interestRate / 100);
    }

    // Withdraw method deducts money if there is sufficient balance
    @Override
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Override displayBalance method
    @Override
    public void displayBalance() {
        System.out.println("Savings Account Balance: " + balance);
    }
}

// CheckingAccount class extends BankAccount and allows overdrafts
class CheckingAccount extends BankAccount {
    private double overdraftLimit; // Overdraft limit

    // Constructor to initialize balance and overdraft limit
    public CheckingAccount(double balance, double overdraftLimit) {
        super(balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Default constructor with preset balance and overdraft limit
    public CheckingAccount() {
        this(1000.0, 500.0); // Default balance and overdraft limit
    }

    // Deposit method simply adds amount to balance
    @Override
    void deposit(double amount) {
        balance += amount;
    }

    // Withdraw method checks if withdrawal exceeds overdraft limit
    @Override
    void withdraw(double amount) {
        if (balance - amount >= -overdraftLimit) {
            balance -= amount;
        } else {
            System.out.println("Cannot withdraw. Exceeds overdraft limit.");
        }
    }

    // Override displayBalance method
    @Override
    public void displayBalance() {
        System.out.println("Checking Account Balance: " + balance);
    }
}

// Main class to test SavingsAccount and CheckingAccount
public class BankAccountTest {
    public static void main(String[] args) {
        // Creating a SavingsAccount with initial balance 1000 and 5% interest rate
        SavingsAccount savings = new SavingsAccount(1000, 5);
        savings.deposit(50); // Depositing 50 (includes interest)
        savings.displayBalance();

        // Creating a CheckingAccount with initial balance 1200 and overdraft limit 500
        CheckingAccount checking = new CheckingAccount(1200, 500);
        checking.deposit(100); // Depositing 100
        checking.withdraw(200); // Withdrawing 200
        checking.displayBalance();

        // Trying to withdraw 1500 which exceeds the overdraft limit
        checking.withdraw(1500);
        checking.displayBalance();
    }
}

