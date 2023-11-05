package Examples.ParkingLot.models.strategy;

import Examples.ParkingLot.models.ticket.ParkingTicket;

public interface ParkingPriceCalculationStrategy {

    double calculateAmountForParking(ParkingTicket parkingTicket);

}
