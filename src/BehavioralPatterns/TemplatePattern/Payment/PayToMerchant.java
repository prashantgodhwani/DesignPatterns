package BehavioralPatterns.TemplatePattern.Payment;

public class PayToMerchant extends PaymentFlow{

    @Override
    protected void validateRequest() {
        System.out.println("PayToMerchant::validateRequest");
    }

    @Override
    protected void debitAmount() {
        System.out.println("Debiting Amount to send to Merchant");
    }

    @Override
    protected void calculatePlatformFee() {
        System.out.println("2% Platform markup");
    }

    @Override
    protected void creditAmount() {
        System.out.println("Crediting Amount to Merchant");
    }
}
