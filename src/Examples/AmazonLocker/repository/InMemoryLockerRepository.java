package Examples.AmazonLocker.repository;

import Examples.AmazonLocker.exceptions.InvalidSlotException;
import Examples.AmazonLocker.models.Size;
import Examples.AmazonLocker.models.locker.Locker;
import Examples.AmazonLocker.models.locker.LockerSlot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryLockerRepository implements LockerRepository{

    private List<Locker> lockers;

    InMemoryLockerRepository(){
        this.lockers = new ArrayList<>();
    }

    public Locker getLocker(final int id) {
        for (Locker locker : this.lockers) {
            if (locker.getId() == id) {
                return locker;
            }
        }
        return null;
    }

    public void createSlot(Locker locker, Size slotSize){
        locker.addSlot(new LockerSlot((int) (Math.random() * 100), slotSize));
    }

    @Override
    public Locker createLocker(int id) {
        Locker locker = getLocker(id);
        if(getLocker(id) != null)  return locker;

        locker = new Locker(id);
        return locker;
    }

    @Override
    public List<LockerSlot> getAllAvailableSlots() {
        return (lockers.stream()
                .flatMap(locker -> locker.getAllAvailableSlots().stream())
                .filter(LockerSlot::isLockerSlotAvailable)
                .collect(Collectors.toList()));
    }

    @Override
    public Locker getLockerById(int id) {
        Optional<Locker> lockerOpt = lockers.stream()
                .filter(locker -> locker.getId() == id).findFirst();

        if(lockerOpt.isPresent()) return lockerOpt.get();
        else throw new InvalidSlotException();
    }
}
