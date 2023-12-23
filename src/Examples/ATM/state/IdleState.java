package Examples.ATM.state;

import Examples.ATM.models.Card;
import Examples.ATM.models.atm.ATM;
import Examples.ATM.models.exceptions.OperationNotSupportedException;


public class IdleState implements State{

    public IdleState(){
        System.out.println("ATM is in idle State. Waiting for card input....");
    }

    @Override
    public void insertCard(ATM atm, Card card) {
        Card readCard = atm.getCardReader().readCard(card);
        atm.setState(new CardReadState(atm, readCard));
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
        throw new OperationNotSupportedException();
    }
}
