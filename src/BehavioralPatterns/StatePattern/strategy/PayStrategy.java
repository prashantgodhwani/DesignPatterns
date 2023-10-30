package BehavioralPatterns.StatePattern.strategy;

import BehavioralPatterns.StatePattern.models.Money;

import java.util.List;

public interface PayStrategy {

    int pay(int code) throws Exception;
}
