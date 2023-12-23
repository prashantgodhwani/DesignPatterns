package BehavioralPatterns.TemplatePattern.Payment;

public class PayToPersonal extends PaymentFlow{
    @Override
    protected void validateRequest() {
        System.out.println("PayToPersonal::validateRequest");
    }

    @Override
    protected void debitAmount() {
        System.out.println("Debiting Amount to send to Non-Business");
    }

    @Override
    protected void calculatePlatformFee() {
        System.out.println("0% Platform markup");
    }

    @Override
    protected void creditAmount() {
        System.out.println("Crediting Amount to Non-Business");
    }
}
