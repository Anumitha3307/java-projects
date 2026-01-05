package week6;

import java.util.Scanner;

class PrimeSumThread extends Thread {
    private int start, end;
    private long sum = 0;

    public PrimeSumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
    }

    public long getSum() {
        return sum;
    }
}

public class PrimeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit;
        System.out.println("enter the limit");
        limit = sc.nextInt();

        int numThreads = 4; 
        int Size = limit / numThreads;

        PrimeSumThread t1 = new PrimeSumThread(1, Size);
        PrimeSumThread t2 = new PrimeSumThread(Size + 1, 2 * Size);
        PrimeSumThread t3 = new PrimeSumThread(2 * Size + 1, 3 * Size);
        PrimeSumThread t4 = new PrimeSumThread(3 * Size + 1, limit);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
    try{
        
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }catch(InterruptedException e){
        System.err.println(e);
    }


        long totalSum = t1.getSum() + t2.getSum() + t3.getSum() + t4.getSum();

        System.out.println("Sum of prime numbers up to " + limit + " is: " + totalSum);
    }
}
