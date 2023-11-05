package Examples.ParkingLot.models.vehicle;

import Examples.ParkingLot.models.spot.ParkingSpotType;

public abstract class Vehicle {

    VehicleType vehicleType;

    String registrationPlate;

    public Vehicle(VehicleType vehicleType, String registrationPlate) {
        this.vehicleType = vehicleType;
        this.registrationPlate = registrationPlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public ParkingSpotType getParkingSpotType(){
        return switch (vehicleType){
            case CAR -> ParkingSpotType.COMPACT;
            case BIKE -> ParkingSpotType.COMPACT;
            case TRUCK -> ParkingSpotType.LARGE;
            case ELECTRIC_CAR -> ParkingSpotType.ELECTRIC;
        };
    }
}
