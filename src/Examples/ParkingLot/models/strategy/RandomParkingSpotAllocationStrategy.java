package Examples.ParkingLot.models.strategy;

import Examples.ParkingLot.models.exceptions.ParkingNotAvailableException;
import Examples.ParkingLot.models.parking.ParkingFloor;
import Examples.ParkingLot.models.parking.ParkingLot;
import Examples.ParkingLot.models.spot.ParkingSpot;
import Examples.ParkingLot.models.spot.ParkingSpotType;
import Examples.ParkingLot.models.vehicle.Vehicle;

import java.util.Arrays;
import java.util.List;

public class RandomParkingSpotAllocationStrategy extends ParkingSpotAllocationStrategy {

    RandomParkingSpotAllocationStrategy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    @Override
    public ParkingSpot findSpotForVehicle(Vehicle vehicle, boolean isHandicapped) throws ParkingNotAvailableException {
        List<ParkingFloor> parkingFloors = Arrays.stream(this.parkingLot.getParkingFloors()).toList();
        List<ParkingSpot> parkingSpots;
        if(isHandicapped){
            parkingSpots = parkingFloors.stream()
                    .flatMap(parkingFloor -> parkingFloor.getAvailableParkingSpots(ParkingSpotType.HANDICAPPED).stream())
                    .toList();
            return parkingSpots.get(0);
        }else {
            parkingSpots = Arrays.stream(this.parkingLot.getParkingFloors()).toList()
                    .stream().flatMap(parkingFloor -> parkingFloor.getAvailableParkingSpots(vehicle.getParkingSpotType()).stream()).toList();
        }
        if(parkingSpots.isEmpty()) throw new ParkingNotAvailableException();
        else return parkingSpots.get(0);
    }
}
