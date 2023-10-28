package BehavioralPatterns.StrategyDesignPattern.order;

import BehavioralPatterns.StrategyDesignPattern.strategies.PayStrategy;

public class Order {
    private int totalCost = 0;
    private boolean isClosed = false;

    public void processOrder(PayStrategy payStrategy){
        payStrategy.collectPaymentDetails();
    }

    public void setTotalCost(int cost){
        this.totalCost += cost;
    }

    public int getTotalCost(){
        return this.totalCost;
    }

    public boolean isClosed(){
        return isClosed;
    }

    public void setClosed(){
        this.isClosed = true;
    }
}
