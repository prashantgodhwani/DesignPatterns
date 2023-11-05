package Examples.ParkingLot.models.spot;

public class HandicappedParkingSpot extends ParkingSpot{
    protected HandicappedParkingSpot(Integer id) {
        super(id, ParkingSpotType.HANDICAPPED);
    }
}
