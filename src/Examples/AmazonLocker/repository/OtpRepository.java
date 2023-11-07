package Examples.AmazonLocker.repository;

public interface OtpRepository {

    void addOtp(String otp, int lockerSlotId);

    String getOtp(int lockerSlotId);

}
