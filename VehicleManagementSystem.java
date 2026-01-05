package week3;
class Vehicle {
    protected String vehicleName;
    protected String vehicleType;
    protected String fuelType;

    public Vehicle(String vehicleName, String vehicleType, String fuelType) {
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
    }
    public void displayDetails() {
        System.out.println("Vehicle Details:");
        System.out.println("Vehicle Name: " + vehicleName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Fuel Type: " + fuelType);
    }
}
class Car extends Vehicle {
     private int numberOfDoors;

    public Car(String vehicleName, String vehicleType, String fuelType, int numberOfDoors) {
        super(vehicleName, vehicleType, fuelType);
        this.numberOfDoors = numberOfDoors;
    }
    @Override
    public void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Vehicle Name: " + vehicleName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}
class Bike extends Vehicle {
    private boolean hasCarrier;
    public Bike(String vehicleName, String vehicleType, String fuelType, boolean hasCarrier) {
        super(vehicleName, vehicleType, fuelType);
        this.hasCarrier = hasCarrier;
    }
    @Override
    public void displayDetails() {
        System.out.println("Bike Details:");
        System.out.println("Vehicle Name: " + vehicleName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Has Carrier: " + (hasCarrier ? "Yes" : "No"));
    }
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        Car car = new Car("Toyota Corolla", "Car", "Petrol", 4);
        Bike bike = new Bike("Yamaha FZ", "Bike", "Petrol", true);
        car.displayDetails();
        System.out.println(); 
        bike.displayDetails();
    }
}
