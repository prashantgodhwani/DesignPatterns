package Examples.AmazonLocker.models.locker;

import Examples.AmazonLocker.exceptions.InvalidSlotException;
import Examples.AmazonLocker.exceptions.SlotNotAvailableException;
import Examples.AmazonLocker.models.Size;
import Examples.AmazonLocker.models.order.OrderPackage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Locker {

    private final int id;

    private boolean isFunctional;

    private Map<Integer, LockerSlot> lockerSlots;

    public Locker(int id) {
        this.id = id;
        isFunctional = true;
    }

    public int getId() {
        return id;
    }

    public void addSlot(LockerSlot lockerSlot){
        if(!lockerSlots.containsKey(lockerSlot.getLockerSlotId()))
            this.lockerSlots.put(lockerSlot.getLockerSlotId(), lockerSlot);
        else throw new RuntimeException("Invalid lockerId exception");
    }

    public void placeOrderAtSlot(int slotId, OrderPackage orderPackage){

        if(!lockerSlots.containsKey(slotId))
            throw new InvalidSlotException();

        LockerSlot slot = lockerSlots.get(slotId);
        if(!slot.isLockerSlotAvailable()){
            throw new SlotNotAvailableException();
        }

        slot.placeOrderAtSlot(orderPackage);
    }

    public List<LockerSlot> getAllAvailableSlots(){
        return lockerSlots.values().stream().filter(LockerSlot::isLockerSlotAvailable).collect(Collectors.toList());
    }

}
