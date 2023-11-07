package Examples.AmazonLocker.controllers;

import Examples.AmazonLocker.models.locker.LockerSlot;
import Examples.AmazonLocker.models.order.OrderPackage;
import Examples.AmazonLocker.models.user.Customer;
import Examples.AmazonLocker.service.LockerService;
import Examples.AmazonLocker.service.NotificationService;
import Examples.AmazonLocker.service.OTPService;

public class OrderController {

    private final OTPService otpService;
    private final NotificationService notificationService;
    private final LockerService lockerService;

    public OrderController(final NotificationService notificationService,
                           final OTPService otpService,
                           final LockerService lockerService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
        this.notificationService = notificationService;
    }

    public LockerSlot allocateLocker(final Customer buyer, final OrderPackage orderPackage) {
        final LockerSlot slot = lockerService.allocateSlot(orderPackage);
        final String otp = otpService.generateOtp(slot.getLockerSlotId());
        notificationService.notifyUser(buyer, otp, slot);
        return slot;
    }
}
