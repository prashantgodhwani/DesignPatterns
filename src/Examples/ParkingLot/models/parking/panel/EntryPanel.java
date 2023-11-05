package Examples.ParkingLot.models.parking.panel;

import Examples.ParkingLot.models.parking.ParkingFloor;
import Examples.ParkingLot.models.spot.ParkingSpot;
import Examples.ParkingLot.models.ticket.ParkingTicket;
import Examples.ParkingLot.models.vehicle.Vehicle;

public class EntryPanel {

    private String entryPanelId;

    public ParkingTicket generateParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot, ParkingFloor parkingFloor){
        ParkingTicket parkingTicket = new ParkingTicket(""+Math.random() * 10,
                vehicle, parkingSpot, parkingFloor, this, System.currentTimeMillis());
        return parkingTicket;
    }

}
