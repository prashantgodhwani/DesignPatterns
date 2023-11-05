package Examples.Elevator;

import Examples.Elevator.location.Location;

public class Request {

    int fromFloor;

    int desiredFloor;

    Direction direction;

    Location location;

    boolean isScheduled;

    public Request(int fromFloor, int desiredFloor, Direction direction, Location location) {
        this.fromFloor = fromFloor;
        this.desiredFloor = desiredFloor;
        this.direction = direction;
        this.location = location;
        this.isScheduled = false;
    }

    public int getFromFloor() {
        return fromFloor;
    }

    public int getDesiredFloor() {
        return desiredFloor;
    }

    public boolean isScheduled() {
        return isScheduled;
    }

    public void schedule(Elevator elevator) {
        System.out.println("Scheduled " + this.fromFloor + " -> " + this.desiredFloor + " in " + elevator.getId());
        isScheduled = true;
    }
}
