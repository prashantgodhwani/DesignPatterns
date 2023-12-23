package Examples.ATM;

import Examples.ATM.models.Account;
import Examples.ATM.models.AccountType;
import Examples.ATM.models.Bank;
import Examples.ATM.models.Person;
import Examples.ATM.models.atm.ATM;
import Examples.ATM.state.State;

public class Demo {

    public static void main(String[] args) {
        Person person = new Person("Prashant");
        Bank bank = new Bank();
        Account account = bank.openAccount(person, AccountType.SAVINGS);
        System.out.println(account.getCard().getPin());

        ATM atm = new ATM();
        State state = atm.getState();
        System.out.println("ATM STATE " + state.toString());

        state.insertCard(atm, account.getCard());

        state = atm.getState();

        state.enterPin();

        state = atm.getState();

        state.displayActionGuide();

        state = atm.getState();

        state.dispense();

        state = atm.getState();

        state.ejectCard();
    }

}
