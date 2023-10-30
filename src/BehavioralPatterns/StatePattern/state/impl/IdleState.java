package BehavioralPatterns.StatePattern.state.impl;

import BehavioralPatterns.StatePattern.models.Item;
import BehavioralPatterns.StatePattern.models.Money;
import BehavioralPatterns.StatePattern.models.VendingMachine;
import BehavioralPatterns.StatePattern.state.State;

import java.util.List;

public class IdleState implements State {

    public IdleState(){
        System.out.println("Currently Vending machine is in IdleState");
    }

    public IdleState(VendingMachine machine){
        System.out.println("Currently Vending machine is in IdleState");
    }


    @Override
    public void onProductSelectionClick(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new ProductSelectionState(vendingMachine));
    }

    @Override
    public void onProductConfirmationClick(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("Cannot confirm product without selection");
    }

    @Override
    public void onPaymentInititation(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Cannot initiate Payment without selection");
    }

    @Override
    public void onDispense(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Cannot dispense product without selection");
    }

    @Override
    public void onCancelTransaction(VendingMachine vendingMachine, int cost) throws Exception {
        throw new Exception("Cannot cancel transaction at idle");
    }

    @Override
    public List<Money> refundMoney(VendingMachine vendingMachine, int cost) throws Exception {
        throw new Exception("Cannot refund at idle");
    }
}
