package kalyan.design.elevator;

import java.util.List;

public class InternalDispatcher {

    List<ElevatorController>  elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitInternalRequest(int floor, Direction direction){
        for(ElevatorController elevatorController : elevatorControllerList) {
            int elevatorID = elevatorController.elevatorCar.id;
            if (elevatorID%2==1 && floor%2==1){
                elevatorController.submitInternalRequest(floor, direction);
            } else if(elevatorID%2==0 && floor%2==0){
                elevatorController.submitInternalRequest(floor, direction);
            }
        }
    }
}
