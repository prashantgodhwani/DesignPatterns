package Examples.ATM.state;

import Examples.ATM.models.Card;
import Examples.ATM.models.atm.ATM;
import Examples.ATM.models.exceptions.OperationNotSupportedException;

public class CardReadState implements State{

    private final ATM atm;
    private final Card card;

    public CardReadState(ATM atm, Card card) {
        this.atm = atm;
        this.card = card;
    }

    @Override
    public void insertCard(ATM atm, Card card) {
        throw new OperationNotSupportedException();
    }

    @Override
    public void enterPin() {
        int pin = atm.getPanel().readInput();
        if(card.authenticate(""+pin))
            atm.setState(new AuthorizedUserState(atm, card));
        else ejectCard();
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
