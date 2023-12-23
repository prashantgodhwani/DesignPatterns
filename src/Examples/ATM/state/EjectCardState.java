package Examples.ATM.state;

import Examples.ATM.models.Card;
import Examples.ATM.models.atm.ATM;
import Examples.ATM.models.exceptions.OperationNotSupportedException;

public class EjectCardState implements State{

    private final ATM atm;

    public EjectCardState(ATM atm){
        this.atm = atm;
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
        throw new OperationNotSupportedException();
    }

    @Override
    public void ejectCard() {
        this.atm.setState(new EjectCardState(atm));
    }
}
