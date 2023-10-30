package BehavioralPatterns.StatePattern.state.impl;

import BehavioralPatterns.StatePattern.models.Item;
import BehavioralPatterns.StatePattern.models.Money;
import BehavioralPatterns.StatePattern.models.VendingMachine;
import BehavioralPatterns.StatePattern.state.State;
import BehavioralPatterns.StatePattern.strategy.PayByCardStrategy;
import BehavioralPatterns.StatePattern.strategy.PayByCashStrategy;
import BehavioralPatterns.StatePattern.strategy.PayStrategy;

import java.util.List;
import java.util.Scanner;

public class PaymentInitiationState implements State {

    private int code;

    static Scanner sc;

    public PaymentInitiationState(VendingMachine vendingMachine, int code) {
        this.code = code;
        sc = new Scanner(System.in);
        System.out.println("Currently Vending machine is in PaymentInitiationState");
    }

    public PaymentInitiationState(){
        System.out.println("Currently Vending machine is in PaymentInitiationState");
    }

    @Override
    public void onProductSelectionClick(VendingMachine vendingMachine) throws Exception{
        throw new Exception("Cannot select product without dispensing last selection");
    }

    @Override
    public void onProductConfirmationClick(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("Cannot select product without dispensing last selection");
    }

    @Override
    public void onPaymentInititation(VendingMachine vendingMachine) throws Exception {
        Item item = vendingMachine.getInventory().get(code);
        System.out.println("Total cost of item is = " + item.getPrice());
        System.out.print("Enter payment mode : ");
        int mode = sc.nextInt();
        if(mode == 1){
            new PayByCardStrategy().pay(code);
            vendingMachine.setVendingMachineState(new DispenseItemState(code));
        }else{
            int money = new PayByCashStrategy().pay(code);
            int itemPrice = vendingMachine.getInventory().get(code).getPrice();
            if(money == itemPrice){
                vendingMachine.setVendingMachineState(new DispenseItemState(code));
            }else{
                System.out.println("Refunding " + (money - itemPrice) + " amount and dispensing");
                vendingMachine.setVendingMachineState(new DispenseItemState(code));
            }
        }
    }

    @Override
    public void onDispense(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Cannot dispense product without completing payment");
    }

    @Override
    public void onCancelTransaction(VendingMachine vendingMachine, int cost) throws Exception {
        throw new Exception("Can Cancel transaction after completing payment");
    }

    @Override
    public List<Money> refundMoney(VendingMachine vendingMachine, int cost) throws Exception {
        throw new Exception("Cannot refund before payment");
    }
}
