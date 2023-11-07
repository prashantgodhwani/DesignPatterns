package Examples.AmazonLocker.repository;

import Examples.AmazonLocker.models.locker.Locker;
import Examples.AmazonLocker.models.locker.LockerSlot;

import java.util.List;

public interface LockerRepository {

    Locker createLocker(int id);

    List<LockerSlot> getAllAvailableSlots();

    Locker getLockerById(int id);
}
