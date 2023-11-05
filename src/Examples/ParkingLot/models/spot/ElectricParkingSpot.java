package Examples.ParkingLot.models.spot;

public class ElectricParkingSpot extends ParkingSpot{
    protected ElectricParkingSpot(Integer id) {
        super(id, ParkingSpotType.ELECTRIC);
    }
}
