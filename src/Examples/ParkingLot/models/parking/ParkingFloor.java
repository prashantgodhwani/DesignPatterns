package Examples.ParkingLot.models.parking;

import Examples.ParkingLot.models.parking.panel.EntryPanel;
import Examples.ParkingLot.models.parking.panel.ExitPanel;
import Examples.ParkingLot.models.spot.ParkingSpot;
import Examples.ParkingLot.models.spot.ParkingSpotType;
import Examples.ParkingLot.models.ticket.ParkingTicket;
import Examples.ParkingLot.models.vehicle.Vehicle;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingFloor {

    private final int floorNumber;

    private final Map<ParkingSpotType, List<ParkingSpot>> parkingSpotList;

    private final List<EntryPanel> entries;

    private final List<ExitPanel> exits;

    public ParkingFloor(int floorNumber, Map<ParkingSpotType, List<ParkingSpot>> parkingSpotList, List<EntryPanel> entires, List<ExitPanel> exits) {
        this.floorNumber = floorNumber;
        this.parkingSpotList = parkingSpotList;
        this.entries = entires;
        this.exits = exits;
    }

    public List<ParkingSpot> getAvailableParkingSpots(ParkingSpotType parkingSpotType){
        if(parkingSpotList.containsKey(parkingSpotType)) {
            return parkingSpotList.get(parkingSpotType).stream()
                            .filter(ParkingSpot::isParkingSpotFree)
                            .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public ParkingTicket exitParkingSpot(ExitPanel exitPanel, ParkingTicket parkingTicket){
        return exitPanel.exitParking(parkingTicket);
    }

    public List<ParkingSpot> getAvailableParkingSpots(Vehicle vehicle){
        return getAvailableParkingSpots(vehicle.getParkingSpotType());
    }
}
