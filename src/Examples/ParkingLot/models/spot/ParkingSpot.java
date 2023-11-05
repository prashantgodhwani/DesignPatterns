package Examples.ParkingLot.models.spot;

import Examples.ParkingLot.models.vehicle.Vehicle;

public abstract class ParkingSpot {

    private final Integer id;

    Vehicle vehicle;

    boolean isFree;

    private ParkingSpotType parkingSpotType;

    protected ParkingSpot(Integer id, ParkingSpotType parkingSpotType) {
        this.id = id;
        this.parkingSpotType = parkingSpotType;
    }

    public boolean isParkingSpotFree(){
        return this.isFree;
    }

    public void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isFree = false;
    }

    public Vehicle leaveParking(){
        this.isFree = true;
        Vehicle vehicle = this.vehicle;
        this.vehicle = null;
        return vehicle;
    }


    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }
}
