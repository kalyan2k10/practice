package kalyan.design.elevator;
import java.util.ArrayList;
import java.util.List;

public class ElevatorCreator {
    static List<ElevatorController> elevatorControllerList = new ArrayList<>();
    static ElevatorStrategy elevatorStrategy = new LookUPStrategy();
    static {
        elevatorControllerList.add(new ElevatorController(new ElevatorCar(1), elevatorStrategy));
        elevatorControllerList.add(new ElevatorController(new ElevatorCar(2), elevatorStrategy));
    }
}
