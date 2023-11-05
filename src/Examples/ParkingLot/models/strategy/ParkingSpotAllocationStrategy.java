package Examples.ParkingLot.models.strategy;

import Examples.ParkingLot.models.parking.ParkingLot;
import Examples.ParkingLot.models.spot.ParkingSpot;
import Examples.ParkingLot.models.vehicle.Vehicle;

public abstract class ParkingSpotAllocationStrategy {

    protected ParkingLot parkingLot;

    ParkingSpotAllocationStrategy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public abstract ParkingSpot findSpotForVehicle(Vehicle vehicle, boolean isHandicapped);
}
