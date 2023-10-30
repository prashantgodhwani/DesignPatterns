package BehavioralPatterns.StatePattern.models;

public enum Money {

    RUPEE(1), TEN(10), TWENTY(20), HUNDRED(100);

    private int value;

    private Money(int amount){
        this.value = amount;
    }
}
