package Examples.ATM.state;

import Examples.ATM.models.Card;
import Examples.ATM.models.atm.ATM;
import Examples.ATM.models.exceptions.OperationNotSupportedException;

public class AuthorizedUserState implements State{

    private final ATM atm;
    private final Card card;

    public AuthorizedUserState(ATM atm, Card card) {
        this.atm = atm;
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
        this.atm.getScreen().display("1. Withdraw 2. Balance");
        int choice = this.atm.getPanel().readInput();
        if(choice == 2) this.atm.getScreen().display(""+balanceEnquiry());
        else enterAmount();
    }

    private double balanceEnquiry() {
        return card.getAccount().getBalance();
    }

    private void enterAmount() {
        double amount = this.atm.getPanel().readInput();
        atm.setState(new DispenseState(atm, amount, card));
    }

    @Override
    public void dispense() {
        throw new OperationNotSupportedException();
    }

    @Override
    public void ejectCard() {
        this.atm.setState(new EjectCardState(atm));
    }
}
