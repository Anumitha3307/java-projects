package week6;

class SharedResource {
    private int data;
    private boolean hasData = false;
    
    public synchronized void produce(int item) throws InterruptedException {
        
        while (hasData) {
            wait(); // Wait if data is already produced
        }
        
        data = item;
        hasData = true;
        System.out.println("Produced: " + item);
        notify(); // Notify consumer
        
    }

    public synchronized int consume() throws InterruptedException {
        while (!hasData) {
            wait(); // Wait if no data is available
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify(); // Notify producer
        return data;
    }
}

class Producer extends Thread {
    private SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void run() {
        int item = 0;
        while (true) {
            try {
                while(item<10){
                sharedResource.produce(++item);
                Thread.sleep(500); // Simulate time delay
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void run() {
        while (true) {
            try {
                sharedResource.consume();
                Thread.sleep(1000); // Simulate time delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Producer p = new Producer(sharedResource);
        Consumer c = new Consumer(sharedResource);
        p.start();
        c.start();
        
    }
}