package Examples.Elevator;

import java.util.Comparator;

public class SimpleElevatorStrategy implements Comparator<Request> {

    @Override
    public int compare(Request r1, Request r2) {
        return r1.desiredFloor - r2.desiredFloor;
    }
}
