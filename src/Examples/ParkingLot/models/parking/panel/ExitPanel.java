package Examples.ParkingLot.models.parking.panel;

import Examples.ParkingLot.models.strategy.ParkingPriceCalculationStrategy;
import Examples.ParkingLot.models.ticket.ParkingTicket;

public class ExitPanel {

    private String id;

    private final ParkingPriceCalculationStrategy strategy;

    public ExitPanel(String id, ParkingPriceCalculationStrategy strategy) {
        this.id = id;
        this.strategy = strategy;
    }

    private void completeExitFormalities(ParkingTicket parkingTicket){
        parkingTicket.setExitPanel(this);
        parkingTicket.setEndTime(System.currentTimeMillis());
        parkingTicket.setAmount(strategy.calculateAmountForParking(parkingTicket));
    }

    public ParkingTicket exitParking(ParkingTicket parkingTicket){
        parkingTicket.getParkingSpot().leaveParking();
        completeExitFormalities(parkingTicket);
        return parkingTicket;
    }
}
