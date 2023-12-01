package kalyan.design.strategy;

public class Main {
    public static void main(String[] args) {
        Vehicle sp1 = new Vehicle();
        sp1.setDriveStrategy(new SpecialDrive());
        sp1.drive();
        sp1.setDriveStrategy(new NormalDrive());
        sp1.drive();
    }
}
