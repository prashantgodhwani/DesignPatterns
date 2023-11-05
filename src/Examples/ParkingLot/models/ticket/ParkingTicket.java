package Examples.ParkingLot.models.ticket;

import Examples.ParkingLot.models.parking.panel.EntryPanel;
import Examples.ParkingLot.models.parking.panel.ExitPanel;
import Examples.ParkingLot.models.parking.ParkingFloor;
import Examples.ParkingLot.models.vehicle.Vehicle;
import Examples.ParkingLot.models.spot.ParkingSpot;

public class ParkingTicket {

    private String parkingTicketId;

    private Vehicle vehicle;

    private ParkingSpot parkingSpot;

    private ParkingFloor parkingFloor;

    private EntryPanel entryPanel;

    private ExitPanel exitPanel;

    private long startTime;

    private long endTime;

    private double amount;

    public ParkingTicket(String parkingTicketId, Vehicle vehicle, ParkingSpot parkingSpot, ParkingFloor parkingFloor, EntryPanel entryPanel, long startTime) {
        this.parkingTicketId = parkingTicketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.parkingFloor = parkingFloor;
        this.entryPanel = entryPanel;
        this.startTime = startTime;
    }

    public String getParkingTicketId() {
        return parkingTicketId;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setExitPanel(ExitPanel exitPanel) {
        this.exitPanel = exitPanel;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
