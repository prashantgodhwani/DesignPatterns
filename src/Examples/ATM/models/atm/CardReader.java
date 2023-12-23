package Examples.ATM.models.atm;

import Examples.ATM.models.Card;

public class CardReader {

    public Card readCard(Card card){
        System.out.println("reading card");
        return card;
    }

    public void ejectCard(){
        System.out.println("ejected card...");
    }

}
