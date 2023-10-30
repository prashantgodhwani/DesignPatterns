package BehavioralPatterns.StatePattern.state.impl;

import BehavioralPatterns.StatePattern.models.Item;
import BehavioralPatterns.StatePattern.models.Money;
import BehavioralPatterns.StatePattern.models.VendingMachine;
import BehavioralPatterns.StatePattern.state.State;

import java.util.List;

public class ProductSelectionState implements State {

    private VendingMachine vendingMachine;

    public ProductSelectionState(){
        System.out.println("Currently Vending machine is in ProductSelectionState");
    }

    public ProductSelectionState(VendingMachine machine){
        this.vendingMachine = machine;
        System.out.println("Currently Vending machine is in ProductSelectionState");
    }

    @Override
    public void onProductSelectionClick(VendingMachine vendingMachine) throws Exception {
        return;
    }

    @Override
    public void onProductConfirmationClick(VendingMachine vendingMachine, int code) throws Exception {
        vendingMachine.setVendingMachineState(new PaymentInitiationState(vendingMachine, code));
    }

    @Override
    public void onPaymentInititation(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Cannot initiate Payment without paying via card/cash");
    }

    @Override
    public void onDispense(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Cannot dispense product without payment");
    }

    @Override
    public void onCancelTransaction(VendingMachine vendingMachine, int cost) throws Exception {
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
    }

    @Override
    public List<Money> refundMoney(VendingMachine vendingMachine, int cost) throws Exception {
        throw new Exception("Cannot refund before payment");
    }
}
