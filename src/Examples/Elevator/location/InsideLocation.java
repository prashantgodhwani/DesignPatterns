package Examples.Elevator.location;

public class InsideLocation extends Location{

    int elevator;

    public InsideLocation(int elevator) {
        super(LocationType.INSIDE_ELEVATOR);
        this.elevator = elevator;
    }

    public int getElevator() {
        return elevator;
    }
}
