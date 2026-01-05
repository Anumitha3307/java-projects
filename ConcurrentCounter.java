package week6;

class CounterIncrementer implements Runnable {
    private static int counter = 0;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 1000; i++) {
            counter++; // Thread-safe increment using synchronized method
        }
    }

    public static synchronized int getCounter() {
        return counter;
    }
}


public class ConcurrentCounter {
    public static void main(String[] args) {
        int numThreads = 10;
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new CounterIncrementer());
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join(); // Wait for all threads to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final Counter Value: " + CounterIncrementer.getCounter());
    }
}
