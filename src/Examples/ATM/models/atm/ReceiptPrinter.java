package Examples.ATM.models.atm;

import Examples.ATM.models.Card;

public class ReceiptPrinter {

    public void printReceipt(Card card, double amount){
        System.out.println("Txn - " + amount + ", card = " + card.getCardNumber());
    }

}
