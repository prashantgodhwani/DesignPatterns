package BehavioralPatterns.StatePattern.strategy;

import BehavioralPatterns.StatePattern.models.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayByCashStrategy implements PayStrategy{

    static Scanner sc;

    public PayByCashStrategy(){
        sc = new Scanner(System.in);
    }

    @Override
    public int pay(int cost) throws Exception {
        System.out.println("Paying " + cost + " via Cash");
        return this.acceptCash(cost);
    }

    private int acceptCash(int cost) throws Exception {
        List<Money> moneyList = new ArrayList<>();
        int totalMoney = 0;
        while(totalMoney < cost){
            int money = sc.nextInt();
            if(money == 100) moneyList.add(Money.HUNDRED);
            else if(money == 1) moneyList.add(Money.RUPEE);
            else if(money == 10) moneyList.add(Money.TEN);
            else if(money == 20) moneyList.add(Money.TWENTY);
            else throw new Exception("Invalid currency encountered");
            totalMoney += money;
        }
        return totalMoney;
    }
}
