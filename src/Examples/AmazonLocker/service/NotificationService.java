package Examples.AmazonLocker.service;

import Examples.AmazonLocker.models.user.User;
import Examples.AmazonLocker.models.locker.LockerSlot;

public class NotificationService {

    public void notifyUser(final User user, final String otp, final LockerSlot slot) {
        // Use third party api to send actual notification like sms, email etc.
        System.out.println("Sending notification of otp: " + otp + " to: " + user + " for slot: " + slot.getLockerSlotId());
    }

}
