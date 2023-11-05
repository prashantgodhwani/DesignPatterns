package Examples.Elevator.location;

public class OutsideLocation extends Location{

    private int floor;

    public OutsideLocation(int floor) {
        super(LocationType.OUTSIDE_ELEVATOR);
        this.floor = floor;
    }
}
