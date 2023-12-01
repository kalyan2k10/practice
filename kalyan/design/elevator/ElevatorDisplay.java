package kalyan.design.elevator;

public class ElevatorDisplay {

    int floor;
    Direction direction;
    int elevatorId;

    public void setDisplay(int floor, Direction direction, int elevatorId) {
        this.floor = floor;
        this.direction = direction;
        this.elevatorId = elevatorId;
    }

    public void showDisplay(){
        System.out.println("The elevator with id " + elevatorId + " is at floor " + floor + " going in direction " + direction);
    }
}
