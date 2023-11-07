package Examples.AmazonLocker.repository;

import Examples.AmazonLocker.exceptions.NoOTPRegisteredForLockerSlotException;

import java.util.HashMap;
import java.util.Map;

public class InMemoryOtpRepository implements OtpRepository{

    private Map<Integer, String> lockerSlotOTPMap;

    public InMemoryOtpRepository(){
        this.lockerSlotOTPMap = new HashMap<>();
    }

    @Override
    public void addOtp(String otp, int lockerSlotId) {
        lockerSlotOTPMap.put(lockerSlotId, otp);
    }

    @Override
    public String getOtp(int lockerSlotId) {
        if(lockerSlotOTPMap.containsKey(lockerSlotId)){
            return lockerSlotOTPMap.get(lockerSlotId);
        }
        throw new NoOTPRegisteredForLockerSlotException();
    }
}
