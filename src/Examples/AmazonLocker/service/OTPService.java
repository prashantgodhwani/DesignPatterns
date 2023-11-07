package Examples.AmazonLocker.service;

import Examples.AmazonLocker.repository.OtpRepository;

public class OTPService {

    private final OtpRepository otpRepository;


    public OTPService(OtpRepository otpRepository){
        this.otpRepository = otpRepository;
    }

    public String generateOtp(int lockerSlotId){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(getRandomNumber(10));
        }
        otpRepository.addOtp(stringBuilder.toString(), lockerSlotId);
        return stringBuilder.toString();
    }

    public Integer getRandomNumber(Integer lessThanThis) {
        return (int) (Math.random() * lessThanThis);
    }

    public boolean validateOTP(String otp, int lockerSlotId){
        final String savedOTP = otpRepository.getOtp(lockerSlotId);
        return savedOTP != null && savedOTP.equals(otp);
    }

}
