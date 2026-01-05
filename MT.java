package lab;

class ParkingLot {
    private int totalSpaces;
    private int availableSpaces;

    public ParkingLot(int totalSpaces) {
        this.totalSpaces = totalSpaces;
        this.availableSpaces = totalSpaces;
    }

    public synchronized void park(String carName) {
        System.out.println(carName + " is trying to park...");

        // If no available spaces, car has to wait
        while (availableSpaces == 0) {
            try {
                System.out.println(carName + " is waiting for a parking space...");
                wait(); // wait until space is available
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        availableSpaces--; // occupy one space
        System.out.println(carName + " has parked.");

        try {
            Thread.sleep(1000); // Parked for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        availableSpaces++; // leaving space
        System.out.println(carName + " is leaving the parking lot.");

        notifyAll(); // notify all waiting cars
    }
}

class Car implements Runnable {
    private ParkingLot parkingLot;
    private String carName;

    public Car(ParkingLot parkingLot, String carName) {
        this.parkingLot = parkingLot;
        this.carName = carName;
    }

    @Override
    public void run() {
        parkingLot.park(carName);
    }
}

public class MT {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(2); // Only 2 parking slots

        Thread car1 = new Thread(new Car(parkingLot, "Car1"));
        Thread car2 = new Thread(new Car(parkingLot, "Car2"));
        Thread car3 = new Thread(new Car(parkingLot, "Car3"));

        car1.start();
        car2.start();
        car3.start();
    }
}