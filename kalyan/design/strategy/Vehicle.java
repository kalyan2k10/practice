package kalyan.design.strategy;

public class Vehicle {
    public void setDriveStrategy(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }
    DriveStrategy driveStrategy;
    public void drive() {
        this.driveStrategy.drive();
    }
}
