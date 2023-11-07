package Examples.AmazonLocker.models.location;

import Examples.AmazonLocker.models.locker.Locker;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private List<Locker> lockers;

    private final GeographicLocation geographicLocation;

    public Location(GeographicLocation geographicLocation) {
        this.lockers = new ArrayList<>();
        this.geographicLocation = geographicLocation;
    }
}
