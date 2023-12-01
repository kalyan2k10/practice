package kalyan.design.elevator;

public interface ElevatorStrategy {
    public void submitExternalRequest(ElevatorCar elevatorCar, Direction direction, int floor);
    public void submitInternalRequest(ElevatorCar elevatorCar, Direction direction, int floor);
}
