package BehavioralPatterns.TemplatePattern;

import BehavioralPatterns.TemplatePattern.Payment.PayToMerchant;
import BehavioralPatterns.TemplatePattern.Payment.PayToPersonal;
import BehavioralPatterns.TemplatePattern.Payment.PaymentFlow;

public class Main {

    public static void main(String[] args) {
        PaymentFlow paymentFlow = new PayToMerchant();
        paymentFlow.sendMoney();

        System.out.println("------------------------------");

        paymentFlow = new PayToPersonal();
        paymentFlow.sendMoney();
    }
}
