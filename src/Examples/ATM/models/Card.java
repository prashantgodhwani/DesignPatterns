package Examples.ATM.models;

public class Card {

    private final String cardNumber;

    private String pin;

    private final Account account;

    public Card(Account account){
        this.cardNumber = generateNumber(16);
        this.account = account;
        this.pin = generateNumber(6);
    }

    public String getPin() {
        return pin;
    }

    public String getCardNumber(){
        return this.cardNumber;
    }

    private String generateNumber(int limit){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < limit; i++) {
            stringBuilder.append(getRandomNumber(10));
        }
        return stringBuilder.toString();
    }

    private Integer getRandomNumber(Integer lessThanThis) {
        return (int) (Math.random() * lessThanThis);
    }

    public Account getAccount(){
        return this.account;
    }

    public boolean authenticate(String pin){
        return pin.equals(this.pin);
    }

}
