package kalyan.design.elevator;


public class ElevatorCar {

    int id;
    ElevatorDisplay display;
    InternalButtons internalButtons;
    int currentFloor;
    Direction elevatorDirection;

    public ElevatorCar(int id){
        this.id = id;
        display = new ElevatorDisplay();
        internalButtons = new InternalButtons();
        currentFloor = 0;
        elevatorDirection = Direction.UP;
    }
    public void showDisplay() {
         display.showDisplay();
    }

    public void setDisplay() {
        this.display.setDisplay(currentFloor, elevatorDirection,id);
    }

    boolean moveElevator(Direction dir, int destinationFloor){
        int startFloor = currentFloor;
        if(dir == Direction.UP) {
            for(int i = startFloor; i<=destinationFloor; i++) {

                this.currentFloor = i;
                this.elevatorDirection = dir;
                setDisplay();
                showDisplay();
                if(i == destinationFloor) {
                    System.out.println("The elevator with id " + id + " stops at floor " + i);
                    return true;
                }
            }
        }

        if(dir == Direction.DOWN) {
            for(int i = startFloor; i>=destinationFloor; i--) {

                this.currentFloor = i;
                this.elevatorDirection = dir;
                setDisplay();
                showDisplay();
                if(i == destinationFloor) {
                    System.out.println("The elevator with id " + id + " stops at floor " + i);
                    return true;
                }
            }
        }
        return false;
    }

}
