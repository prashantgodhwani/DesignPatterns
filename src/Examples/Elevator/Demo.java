package Examples.Elevator;

import Examples.Elevator.location.InsideLocation;
import Examples.Elevator.location.OutsideLocation;

public class Demo {

    public static void main(String[] args) {
        ElevatorSystem system = new ElevatorSystem(2, new SimpleElevatorStrategy()); // Create 2 elevators

        Request upRequest1 = new Request(0, 5, Direction.UP, new InsideLocation(0));
        Request upRequest2 = new Request(0, 3, Direction.UP, new InsideLocation(0));
        Request downRequest1 = new Request(0, 1, Direction.DOWN, new OutsideLocation(0));
        Request downRequest2 = new Request(0, 2, Direction.DOWN, new OutsideLocation(0));
        Request downRequest3 = new Request(4, 0, Direction.DOWN, new OutsideLocation(4));

        system.addRequest(upRequest1);
        system.addRequest(upRequest2);
        system.addRequest(downRequest1);
        system.addRequest(downRequest2);
        system.addRequest(downRequest3);

        system.run();
    }
}
