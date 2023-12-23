package Examples.ATM.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    private List<Account> bankAccounts;

    public Bank(){
        this.bankAccounts = new ArrayList<>();
    }

    public Account openAccount(Person person, AccountType accountType){
        Account account = new Account(person, accountType);
        account.requestCard();
        bankAccounts.add(account);
        return account;
    }

}
