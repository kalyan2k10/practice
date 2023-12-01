package kalyan.design.strategy;

public class NormalDrive implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("I am a normal drive");
    }
}
