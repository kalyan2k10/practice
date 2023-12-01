package LowLevelDesign.rideservice;
import java.util.ArrayList;
import java.util.List;

class Location {
    private String name;

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class RideOption {
    private Driver driver;
    private int price;

    public RideOption(Driver driver, int price) {
        this.driver = driver;
        this.price = price;
    }

    public Driver getDriver() {
        return driver;
    }

    public int getPrice() {
        return price;
    }
}

class User {
    private String userID;
    private String name;
    private String location;
    private List<RideOption> rideOptions;
    private Location pickupLocation;  // Added pickupLocation
    private Location dropoffLocation;  // Added dropoffLocation

    public User(String userID, String name, String location) {
        this.userID = userID;
        this.name = name;
        this.location = location;
        this.rideOptions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<RideOption> getRideOptions() {
        return rideOptions;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public Location getDropoffLocation() {
        return dropoffLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public void setDropoffLocation(Location dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public void requestRide(Location pickupLocation, Location dropoffLocation) {
        setPickupLocation(pickupLocation);
        setDropoffLocation(dropoffLocation);
        RideService.matchRide(this, pickupLocation, dropoffLocation);
    }

    public Ride chooseCheapestRide() {
        if (rideOptions.isEmpty()) {
            System.out.println("No ride options available.");
            return null;
        }

        RideOption cheapestOption = rideOptions.get(0);

        for (RideOption option : rideOptions) {
            if (option.getPrice() < cheapestOption.getPrice()) {
                cheapestOption = option;
            }
        }

        return new Ride(this, cheapestOption.getDriver(), pickupLocation, dropoffLocation, cheapestOption.getPrice());
    }
}


class Driver {
    private String driverID;
    private String name;
    private String carDetails;
    private String location;
    private boolean available;

    public Driver(String driverID, String name, String carDetails, String location) {
        this.driverID = driverID;
        this.name = name;
        this.carDetails = carDetails;
        this.location = location;
        this.available = false;
    }

    public String getName() {
        return name;
    }

    public String getCarDetails() {
        return carDetails;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Ride {
    private User user;
    private Driver driver;
    private Location pickupLocation;
    private Location dropoffLocation;
    private int price;

    public Ride(User user, Driver driver, Location pickupLocation, Location dropoffLocation, int price) {
        this.user = user;
        this.driver = driver;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.price = price;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(Location dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public Driver getDriver() {
        return driver;
    }

    public int getPrice() {
        return price;
    }
}

class RideService {
    public static void matchRide(User user, Location pickupLocation, Location dropoffLocation) {
        // Simulated ride matching logic
        Driver laxman = new Driver("101", "Laxman", "SUV", "Hyderabad");
        Driver bharath = new Driver("102", "Bharath", "Sedan", "Hyderabad");

        laxman.setAvailable(true);
        bharath.setAvailable(true);

        int laxmanPrice = calculatePrice(laxman, pickupLocation, dropoffLocation);
        int bharathPrice = calculatePrice(bharath, pickupLocation, dropoffLocation);

        user.getRideOptions().add(new RideOption(laxman, laxmanPrice));
        user.getRideOptions().add(new RideOption(bharath, bharathPrice));
    }

    private static int calculatePrice(Driver driver, Location pickupLocation, Location dropoffLocation) {
        // Simulated price calculation logic (can be based on distance, car type, etc.)
        return 50; // Simplified price for demonstration
    }
}

public class RideSharingApp {
    public static void main(String[] args) {
        // Create users
        User ram = new User("1", "Ram", "Hyderabad");

        // Ram requests a ride from Hyderabad to Bengaluru
        ram.requestRide(new Location("Hyderabad"), new Location("Bengaluru"));

        // Display ride options for Ram
        displayRideOptions(ram);

        // Ram chooses the cheapest option
        Ride chosenRide = ram.chooseCheapestRide();

        // Display chosen ride details
        displayChosenRide(chosenRide);
    }

    private static void displayRideOptions(User user) {
        // Display ride options including drivers, car types, and prices
        System.out.println("Ride options for " + user.getName() + ":");
        for (RideOption option : user.getRideOptions()) {
            System.out.println("Driver: " + option.getDriver().getName() +
                    ", Car Type: " + option.getDriver().getCarDetails() +
                    ", Price: " + option.getPrice());
        }
    }

    private static void displayChosenRide(Ride ride) {
        // Display details of the chosen ride
        System.out.println("Chosen Ride Details:");
        System.out.println("Driver: " + ride.getDriver().getName() +
                ", Car Type: " + ride.getDriver().getCarDetails() +
                ", Price: " + ride.getPrice() +
                ", Pickup Location: " + ride.getPickupLocation().getName() +
                ", Dropoff Location: " + ride.getDropoffLocation().getName());
    }
}
