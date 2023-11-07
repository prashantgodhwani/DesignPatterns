package Examples.AmazonLocker.strategies;

import Examples.AmazonLocker.models.locker.LockerSlot;
import Examples.AmazonLocker.models.order.OrderPackage;

import java.util.List;

public class SizeFirstAvaiableStrategy implements LockerSlotFilterationStrategy{
    @Override
    public LockerSlot filterSlots(List<LockerSlot> availableSlots, OrderPackage orderPackage) {
        for(LockerSlot lockerSlot : availableSlots){
            if(lockerSlot.canContain(orderPackage)){
                return lockerSlot;
            }
        }
        return null;
    }
}
