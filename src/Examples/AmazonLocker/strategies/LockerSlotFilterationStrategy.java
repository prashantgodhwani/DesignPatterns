package Examples.AmazonLocker.strategies;

import Examples.AmazonLocker.models.locker.LockerSlot;
import Examples.AmazonLocker.models.order.OrderPackage;

import java.util.List;

public interface LockerSlotFilterationStrategy {

    LockerSlot filterSlots(List<LockerSlot> availableSlots, OrderPackage orderPackage);
}
