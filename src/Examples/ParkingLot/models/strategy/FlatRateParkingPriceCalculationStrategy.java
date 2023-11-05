package Examples.ParkingLot.models.strategy;

import Examples.ParkingLot.models.ticket.ParkingTicket;

public class FlatRateParkingPriceCalculationStrategy implements ParkingPriceCalculationStrategy{
    @Override
    public double calculateAmountForParking(ParkingTicket parkingTicket) {
        return (parkingTicket.getEndTime() - parkingTicket.getStartTime()) * 10.0;
    }
}
