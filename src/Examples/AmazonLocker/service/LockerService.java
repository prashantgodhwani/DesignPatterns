package Examples.AmazonLocker.service;

import Examples.AmazonLocker.exceptions.NoSlotAvaialbleException;
import Examples.AmazonLocker.models.locker.LockerSlot;
import Examples.AmazonLocker.models.order.OrderPackage;
import Examples.AmazonLocker.repository.LockerRepository;
import Examples.AmazonLocker.strategies.LockerSlotFilterationStrategy;

import java.util.List;

public class LockerService {

    private final LockerRepository lockerRepository;

    private final LockerSlotFilterationStrategy lockerSlotFilterationStrategy;

    public LockerService(LockerRepository lockerRepository, LockerSlotFilterationStrategy lockerSlotFilterationStrategy) {
        this.lockerRepository = lockerRepository;
        this.lockerSlotFilterationStrategy = lockerSlotFilterationStrategy;
    }

    public LockerSlot allocateSlot(OrderPackage orderPackage){
        List<LockerSlot> lockerSlots = lockerRepository.getAllAvailableSlots();
        LockerSlot lockerSlot = lockerSlotFilterationStrategy.filterSlots(lockerSlots, orderPackage);

        if(lockerSlot == null) throw new NoSlotAvaialbleException();
        lockerSlot.placeOrderAtSlot(orderPackage);
        return lockerSlot;
    }

}
