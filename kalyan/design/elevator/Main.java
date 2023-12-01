package kalyan.design.elevator;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        List<Floor> floorList = new ArrayList<>();
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        Floor floor3 = new Floor(3);
        Floor floor4 = new Floor(4);
        Floor floor5 = new Floor(5);
        Floor floor6 = new Floor(6);
        Floor floor7 = new Floor(7);
        Floor floor8 = new Floor(8);
        Floor floor9 = new Floor(9);
        Floor floor10 = new Floor(10);
        Floor floor11 = new Floor(11);
        Floor floor12 = new Floor(12);
        Floor floor13 = new Floor(13);

        floorList.add(floor1);
        floorList.add(floor2);
        floorList.add(floor3);
        floorList.add(floor4);
        floorList.add(floor5);
        floorList.add(floor6);
        floorList.add(floor7);
        floorList.add(floor8);
        floorList.add(floor9);
        floorList.add(floor10);
        floorList.add(floor11);
        floorList.add(floor12);
        floorList.add(floor13);
        Building building = new Building(floorList);

        ElevatorCar ec = ElevatorCreator.elevatorControllerList.get(0).elevatorCar;


        ec.currentFloor = 7;
        ec.elevatorDirection = Direction.DOWN;
        floor3.pressButton(Direction.DOWN);
        floor5.pressButton(Direction.DOWN);
        floor9.pressButton(Direction.UP);
        floor13.pressButton(Direction.UP);
        ec.internalButtons.pressButton(1,Direction.DOWN);

    }
}
