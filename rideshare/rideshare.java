import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Driver {
    private String name;
    private String carModel;
    private String licensePlate;

    public Driver(String name, String carModel, String licensePlate) {
        this.name = name;
        this.carModel = carModel;
        this.licensePlate = licensePlate;
    }

    public String getName() {
        return name;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void displayInfo() {
        System.out.println("Driver Name: " + name);
        System.out.println("Car Model: " + carModel);
        System.out.println("License Plate: " + licensePlate);
    }
}

class Rider {
    private String name;
    private String pickupLocation;
    private String dropLocation;

    public Rider(String name, String pickupLocation, String dropLocation) {
        this.name = name;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
    }

    public String getName() {
        return name;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void displayInfo() {
        System.out.println("Rider Name: " + name);
        System.out.println("Pickup Location: " + pickupLocation);
        System.out.println("Drop Location: " + dropLocation);
    }
}

class Ride {
    private Driver driver;
    private Rider rider;

    public Ride(Driver driver, Rider rider) {
        this.driver = driver;
        this.rider = rider;
    }

    public void startRide() {
        System.out.println("Ride started.");
        driver.displayInfo();
        rider.displayInfo();
    }

    public void endRide() {
        System.out.println("Ride ended. Thank you for riding with us!");
    }
}

public class rideshare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter driver details:");
        System.out.print("Name: ");
        String driverName = scanner.nextLine();
        System.out.print("Car Model: ");
        String carModel = scanner.nextLine();
        System.out.print("License Plate: ");
        String licensePlate = scanner.nextLine();

        Driver driver = new Driver(driverName, carModel, licensePlate);

        System.out.println("\nEnter rider details:");
        System.out.print("Name: ");
        String riderName = scanner.nextLine();
        System.out.print("Pickup Location: ");
        String pickupLocation = scanner.nextLine();
        System.out.print("Drop Location: ");
        String dropLocation = scanner.nextLine();

        Rider rider = new Rider(riderName, pickupLocation, dropLocation);

        Ride ride = new Ride(driver, rider);

        System.out.println("\nStarting the ride...");
        ride.startRide();

        System.out.println("\nEnding the ride...");
        ride.endRide();

        scanner.close();
    }
}