package Examples.ATM.state;

import Examples.ATM.models.Card;
import Examples.ATM.models.atm.ATM;
import Examples.ATM.models.exceptions.OperationNotSupportedException;

public class DispenseState implements State{

    private final ATM atm;
    private final double amount;
    private final Card card;

    public DispenseState(ATM atm, double amount, Card card){
        this.atm = atm;
        this.amount = amount;
        this.card = card;
    }
    @Override
    public void insertCard(ATM atm, Card card) {
        throw new OperationNotSupportedException();
    }

    @Override
    public void enterPin() {
        throw new OperationNotSupportedException();
    }

    @Override
    public void displayActionGuide() {
        throw new OperationNotSupportedException();
    }

    @Override
    public void dispense() {
        System.out.println("Dispensing Cash");
        if(atm.dispense(card, amount)){
            atm.getReceiptPrinter().printReceipt(card, amount);
            atm.setState(new EjectCardState(atm));
        }else{
            atm.getScreen().display("Insufficient funds");
            atm.setState(new EjectCardState(atm));
        }
    }

    @Override
    public void ejectCard() {
        throw new OperationNotSupportedException();
    }
}
