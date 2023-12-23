package Examples.ATM.models;

public class Account {

    final Person person;

    final AccountType type;

    double balance;

    Card card;

    public Account(Person person, AccountType accountType){
        this.person = person;
        this.type = accountType;
        this.balance = 100;
        this.card = null;
    }

    public Card requestCard(){
        this.card = new Card(this);
        return this.card;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount){
        this.balance -= amount;
    }

    public Card getCard() {
        return card;
    }
}
