package Examples.ATM.models.atm;

import Examples.ATM.models.Card;
import Examples.ATM.state.IdleState;
import Examples.ATM.state.State;

public class ATM {

    private final Screen screen;

    private final CardReader cardReader;

    private final CashDispenser cashDispenser;

    private final ReceiptPrinter receiptPrinter;

    private final Panel panel;

    private State state;


    public ATM() {
        this.screen = new Screen();
        this.cardReader = new CardReader();
        this.cashDispenser = new CashDispenser();
        this.receiptPrinter = new ReceiptPrinter();
        this.panel = new Panel();
        this.state = new IdleState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public CardReader getCardReader() {
        return cardReader;
    }

    public Panel getPanel() {
        return panel;
    }

    public Screen getScreen() {
        return screen;
    }

    public boolean dispense(Card card, double amount){
        if(card.getAccount().getBalance() > amount){
            card.getAccount().withdraw(amount);
            this.cashDispenser.dispenseCash(amount);
            return true;
        }
        return false;
    }

    public ReceiptPrinter getReceiptPrinter() {
        return receiptPrinter;
    }
}
