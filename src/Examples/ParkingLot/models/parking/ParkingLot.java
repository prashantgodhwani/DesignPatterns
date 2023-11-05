package Examples.ParkingLot.models.parking;

import Examples.ParkingLot.models.parking.panel.ExitPanel;
import Examples.ParkingLot.models.spot.ParkingSpot;
import Examples.ParkingLot.models.strategy.ParkingSpotAllocationStrategy;
import Examples.ParkingLot.models.ticket.ParkingTicket;
import Examples.ParkingLot.models.vehicle.Vehicle;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

public class ParkingLot {

    private final String name;

    private final String id;

    private final String address;

    private final ParkingFloor[] parkingFloors;

    private final ParkingSpotAllocationStrategy parkingSpotAllocationStrategy;

    ParkingLot(String name, String address, ParkingFloor[] parkingFloors, ParkingSpotAllocationStrategy parkingSpotAllocationStrategy){
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.address = address;
        this.parkingFloors = parkingFloors;
        this.parkingSpotAllocationStrategy = parkingSpotAllocationStrategy;
    }

    public ParkingFloor[] getParkingFloors() {
        return parkingFloors;
    }

    public ParkingSpot getAvailableParkingSpot(Vehicle vehicle, boolean isHandicapped){
        return parkingSpotAllocationStrategy.findSpotForVehicle(vehicle, isHandicapped);
    }

    public ParkingSpot parkVehicle(Vehicle vehicle, boolean isHandicapped){
        ParkingSpot parkingSpot = getAvailableParkingSpot(vehicle, isHandicapped);
        parkingSpot.parkVehicle(vehicle);
        return parkingSpot;
    }

    private void vacateParkingSpot(ExitPanel exitPanel, ParkingTicket parkingTicket){
        exitPanel.exitParking(parkingTicket);
    }

}
