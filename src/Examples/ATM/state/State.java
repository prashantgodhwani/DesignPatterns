package Examples.ATM.state;

import Examples.ATM.models.Card;
import Examples.ATM.models.atm.ATM;

public interface State {

    void insertCard(ATM atm, Card card);

    void enterPin();

    void displayActionGuide();

    void dispense();

    void ejectCard();

}
