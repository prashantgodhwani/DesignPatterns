package BehavioralPatterns.TemplatePattern.Payment;

public abstract class PaymentFlow {

    protected abstract void validateRequest();
    protected abstract void debitAmount();
    protected abstract void calculatePlatformFee();
    protected abstract void creditAmount();

    public final void sendMoney(){
        validateRequest();
        debitAmount();
        calculatePlatformFee();
        creditAmount();
    }
}
