package BehavioralPatterns.StrategyDesignPattern.strategies;

import BehavioralPatterns.StrategyDesignPattern.models.CreditCard;

import java.util.Scanner;

public class PayViaCreditCard implements PayStrategy{

    private Scanner scanner = new Scanner(System.in);

    private CreditCard card;

    @Override
    public boolean pay(int paymentAmount) {
        if(isCardPresent()){
            System.out.println("Paying " + paymentAmount + " using CC.");
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        }
        return false;
    }

    private boolean isCardPresent() {
        return card != null;
    }

    @Override
    public void collectPaymentDetails() {
        try{
            System.out.println("Enter card number : ");
            String cardNumber = scanner.next();

            System.out.println("Enter card expiration date mm/yy : ");
            String cardExpirationDate = scanner.next();

            System.out.println("Enter card CVV : ");
            String cvv = scanner.next();

            card = new CreditCard(cardNumber, cardExpirationDate, cvv);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
