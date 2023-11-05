package Examples.Elevator.location;

public abstract class Location {

    private final LocationType locationType;

    public Location(LocationType locationType) {
        this.locationType = locationType;
    }

    public LocationType getLocationType() {
        return locationType;
    }
}
