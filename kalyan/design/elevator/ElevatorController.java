package kalyan.design.elevator;

public class ElevatorController {
    ElevatorStrategy es;
    ElevatorCar elevatorCar;

    ElevatorController(ElevatorCar elevatorCar, ElevatorStrategy es) {
        this.elevatorCar = elevatorCar;
        this.es = es;
    }

    public void submitExternalRequest(int floor, Direction direction){
        es.submitExternalRequest(elevatorCar, direction, floor);
    }

    public void submitInternalRequest(int floor, Direction direction){
        es.submitInternalRequest(elevatorCar, direction, floor);
    }
}
