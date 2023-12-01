package kalyan.design.strategy;

class SpecialDrive implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("I am a special drive");
    }
}
