package BehavioralPatterns.StatePattern.strategy;

import BehavioralPatterns.StatePattern.models.Money;

import java.util.ArrayList;
import java.util.List;

public class PayByCardStrategy implements PayStrategy{
    @Override
    public int pay(int cost) {
        System.out.println("Paid " + cost + " via credit card");
        return cost;
    }
}
