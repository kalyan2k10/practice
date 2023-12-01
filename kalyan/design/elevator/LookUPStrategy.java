package kalyan.design.elevator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class LookUPStrategy implements ElevatorStrategy{

    PriorityQueue<Integer> minPQ = new PriorityQueue<>();
    PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b-a);
    Deque<Integer> pendingJobs = new ArrayDeque<>();
    public void submitExternalRequest(ElevatorCar elevatorCar, Direction direction,int floor) {
        if (direction == Direction.DOWN) {
            if (floor < elevatorCar.currentFloor) {
                maxPQ.offer(floor);
            } else {
                pendingJobs.add(floor);
            }
        } else {
            if (floor > elevatorCar.currentFloor) {
                minPQ.offer(floor);
            } else {
                pendingJobs.add(floor);
            }
        }
    }

    public void submitInternalRequest(ElevatorCar elevatorCar,Direction direction, int floor) {
        moveElevator(direction, floor, elevatorCar);
    }

    public void moveElevator(Direction direction, int floor,ElevatorCar elevatorCar) {

        elevatorCar.elevatorDirection = direction;
        boolean isFirstTime = true;
        while (true) {
            if (elevatorCar.elevatorDirection == Direction.DOWN) {
                if (isFirstTime) {
                    maxPQ.offer(floor);
                    isFirstTime = false;
                }
                if (!maxPQ.isEmpty()) {
                    elevatorCar.moveElevator(elevatorCar.elevatorDirection, maxPQ.remove());
                } else {
                    elevatorCar.elevatorDirection = Direction.UP;
                    while (!pendingJobs.isEmpty())
                        minPQ.offer(pendingJobs.remove());
                }
            } else {
                if (isFirstTime) {
                    minPQ.offer(floor);
                    isFirstTime = false;
                }
                if (!minPQ.isEmpty()) {
                    elevatorCar.moveElevator(elevatorCar.elevatorDirection, minPQ.remove());
                } else {
                    elevatorCar.elevatorDirection = Direction.DOWN;
                    while (!pendingJobs.isEmpty())
                        maxPQ.offer(pendingJobs.remove());
                }
            }
            if(minPQ.isEmpty() && maxPQ.isEmpty() && pendingJobs.isEmpty())
                break;
        }

    }
}
